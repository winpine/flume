/**
 * Licensed to Cloudera, Inc. under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  Cloudera, Inc. licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cloudera.flume.master;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.cloudera.flume.conf.FlumeConfiguration;
import com.cloudera.flume.reporter.ReportEvent;
import com.cloudera.flume.reporter.Reportable;
import com.cloudera.util.Clock;

/**
 * This manages the last seen and heartbeat data on the master flume
 * configuration node.
 * 
 * There should be no references to Thrift here.
 */
public class StatusManager implements Reportable {

  static Logger log = Logger.getLogger(StatusManager.class);

  public static class NodeStatus {
    public NodeState state;
    public long version;
    public long lastseen;
    public String host;
    public String physicalNode;

    public NodeStatus(NodeState state, long version, long lastseen, String host, String physicalNode) {
      this.state = state;
      this.version = version;
      this.lastseen = lastseen;
      this.physicalNode = physicalNode;
      this.host = host;
    }

    @Override
    public String toString() {
      return "node status (state " + state + ", version " + new Date(version)
          + ", lastseen " + new Date(lastseen) + ", host " + host + ")";
    }
  }

  public enum NodeState {
    HELLO, IDLE, CONFIGURING, ACTIVE, ERROR, LOST
  };

  // runtime state of the flume system
  Map<String, NodeStatus> statuses = new HashMap<String, NodeStatus>();

  public boolean updateHeartbeatStatus(String host, String physicalNode,
      String logicalNode, NodeState stat, long version) {
    log.debug("Heartbeat from host:" + host + " logicalnode:" + logicalNode
        + " (" + stat + "," + new Date(version) + ")");

    boolean configChanged = false;
    synchronized (statuses) {
      NodeStatus status = statuses.get(logicalNode);
      if (status == null) {
        status = new NodeStatus(stat, version, Clock.unixTime(), "", "");
        configChanged = true;
      }

      status.state = stat;
      status.version = version;
      status.lastseen = Clock.unixTime();
      status.host = host;
      status.physicalNode = physicalNode;
      statuses.put(logicalNode, status);
    }

    return configChanged;
  }

  /**
   * checks to see if any node's last heart beat was too long ago
   */
  public void checkup() {
    long now = Clock.unixTime();
    HashMap<String, NodeStatus> ss = null;
    synchronized (statuses) {
      ss = new HashMap<String, NodeStatus>(statuses);
    }
    // max out to missing 10 heart beats
    int maxMissed = FlumeConfiguration.get().getMasterMaxMissedheartbeats();
    long timeout = FlumeConfiguration.get().getConfigHeartbeatPeriod()
        * maxMissed;
    for (Entry<String, NodeStatus> e : ss.entrySet()) {
      NodeStatus ns = e.getValue();
      long delta = now - ns.lastseen;
      if (delta > timeout) {
        ns.state = NodeState.LOST;
      }

    }
    return;

  }

  @Override
  public String getName() {
    return "Status";
  }

  /**
   * TODO (jon) convert to a report
   */
  @Override
  public ReportEvent getReport() {
    StringBuilder status = new StringBuilder();
    status.append("<div class=\"StatusManager\">");
    status
        .append("<h2>Node status</h2>\n<table border=\"1\"><tr><th>node</th><th>status</th><th>version</th><th>last seen delta (s)</th><th>last seen</th></tr>");

    long now = Clock.unixTime();
    for (Entry<String, NodeStatus> e : getNodeStatuses().entrySet()) {
      status.append("\n<tr>");
      NodeStatus v = e.getValue();
      String version = (v.version == 0) ? "none" : new Date(v.version)
          .toString();
      status.append("<td>" + e.getKey() + "</td>");
      status.append("<td>" + v.state + "</td>");
      status.append("<td>" + version + "</td>");
      status.append("<td>" + ((now - v.lastseen) / 1000));
      status.append("<td>" + new Date(v.lastseen) + "</td>");
      status.append("</tr>");
    }
    status.append("</table>");
    status.append("</div>");

    return ReportEvent.createLegacyHtmlReport("", status.toString());
  }

  /**
   * Returns a copy of the hashmap containing the mapping from node names to
   * their status object.
   */
  public Map<String, NodeStatus> getNodeStatuses() {
    HashMap<String, NodeStatus> ss = null;
    synchronized (statuses) {
      ss = new HashMap<String, NodeStatus>(statuses);
    }
    return ss;
  }

  /**
   * Returns the NodeStatus of for the given node name
   */
  public NodeStatus getStatus(String node) {
    synchronized (statuses) {
      return statuses.get(node);
    }
  }
}
