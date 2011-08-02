/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.cloudera.flume.conf.thrift;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.thrift.*;
import org.apache.thrift.meta_data.*;
import org.apache.thrift.protocol.*;

public class FlumeNodeStatus implements TBase<FlumeNodeStatus._Fields>, java.io.Serializable, Cloneable, Comparable<FlumeNodeStatus> {
  private static final TStruct STRUCT_DESC = new TStruct("FlumeNodeStatus");

  private static final TField STATE_FIELD_DESC = new TField("state", TType.I32, (short)1);
  private static final TField VERSION_FIELD_DESC = new TField("version", TType.I64, (short)2);
  private static final TField LASTSEEN_FIELD_DESC = new TField("lastseen", TType.I64, (short)3);
  private static final TField HOST_FIELD_DESC = new TField("host", TType.STRING, (short)4);
  private static final TField PHYSICAL_NODE_FIELD_DESC = new TField("physicalNode", TType.STRING, (short)5);

  /**
   * 
   * @see com.cloudera.flume.conf.thrift.FlumeNodeState
   */
  public com.cloudera.flume.conf.thrift.FlumeNodeState state;
  public long version;
  public long lastseen;
  public String host;
  public String physicalNode;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    /**
     * 
     * @see com.cloudera.flume.conf.thrift.FlumeNodeState
     */
    STATE((short)1, "state"),
    VERSION((short)2, "version"),
    LASTSEEN((short)3, "lastseen"),
    HOST((short)4, "host"),
    PHYSICAL_NODE((short)5, "physicalNode");

    private static final Map<Integer, _Fields> byId = new HashMap<Integer, _Fields>();
    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byId.put((int)field._thriftId, field);
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      return byId.get(fieldId);
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __VERSION_ISSET_ID = 0;
  private static final int __LASTSEEN_ISSET_ID = 1;
  private BitSet __isset_bit_vector = new BitSet(2);

  public static final Map<_Fields, FieldMetaData> metaDataMap = Collections.unmodifiableMap(new EnumMap<_Fields, FieldMetaData>(_Fields.class) {{
    put(_Fields.STATE, new FieldMetaData("state", TFieldRequirementType.DEFAULT, 
        new EnumMetaData(TType.ENUM, com.cloudera.flume.conf.thrift.FlumeNodeState.class)));
    put(_Fields.VERSION, new FieldMetaData("version", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.I64)));
    put(_Fields.LASTSEEN, new FieldMetaData("lastseen", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.I64)));
    put(_Fields.HOST, new FieldMetaData("host", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    put(_Fields.PHYSICAL_NODE, new FieldMetaData("physicalNode", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
  }});

  static {
    FieldMetaData.addStructMetaDataMap(FlumeNodeStatus.class, metaDataMap);
  }

  public FlumeNodeStatus() {
  }

  public FlumeNodeStatus(
    com.cloudera.flume.conf.thrift.FlumeNodeState state,
    long version,
    long lastseen,
    String host,
    String physicalNode)
  {
    this();
    this.state = state;
    this.version = version;
    setVersionIsSet(true);
    this.lastseen = lastseen;
    setLastseenIsSet(true);
    this.host = host;
    this.physicalNode = physicalNode;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public FlumeNodeStatus(FlumeNodeStatus other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    if (other.isSetState()) {
      this.state = other.state;
    }
    this.version = other.version;
    this.lastseen = other.lastseen;
    if (other.isSetHost()) {
      this.host = other.host;
    }
    if (other.isSetPhysicalNode()) {
      this.physicalNode = other.physicalNode;
    }
  }

  public FlumeNodeStatus deepCopy() {
    return new FlumeNodeStatus(this);
  }

  @Deprecated
  public FlumeNodeStatus clone() {
    return new FlumeNodeStatus(this);
  }

  /**
   * 
   * @see com.cloudera.flume.conf.thrift.FlumeNodeState
   */
  public com.cloudera.flume.conf.thrift.FlumeNodeState getState() {
    return this.state;
  }

  /**
   * 
   * @see com.cloudera.flume.conf.thrift.FlumeNodeState
   */
  public FlumeNodeStatus setState(com.cloudera.flume.conf.thrift.FlumeNodeState state) {
    this.state = state;
    return this;
  }

  public void unsetState() {
    this.state = null;
  }

  /** Returns true if field state is set (has been asigned a value) and false otherwise */
  public boolean isSetState() {
    return this.state != null;
  }

  public void setStateIsSet(boolean value) {
    if (!value) {
      this.state = null;
    }
  }

  public long getVersion() {
    return this.version;
  }

  public FlumeNodeStatus setVersion(long version) {
    this.version = version;
    setVersionIsSet(true);
    return this;
  }

  public void unsetVersion() {
    __isset_bit_vector.clear(__VERSION_ISSET_ID);
  }

  /** Returns true if field version is set (has been asigned a value) and false otherwise */
  public boolean isSetVersion() {
    return __isset_bit_vector.get(__VERSION_ISSET_ID);
  }

  public void setVersionIsSet(boolean value) {
    __isset_bit_vector.set(__VERSION_ISSET_ID, value);
  }

  public long getLastseen() {
    return this.lastseen;
  }

  public FlumeNodeStatus setLastseen(long lastseen) {
    this.lastseen = lastseen;
    setLastseenIsSet(true);
    return this;
  }

  public void unsetLastseen() {
    __isset_bit_vector.clear(__LASTSEEN_ISSET_ID);
  }

  /** Returns true if field lastseen is set (has been asigned a value) and false otherwise */
  public boolean isSetLastseen() {
    return __isset_bit_vector.get(__LASTSEEN_ISSET_ID);
  }

  public void setLastseenIsSet(boolean value) {
    __isset_bit_vector.set(__LASTSEEN_ISSET_ID, value);
  }

  public String getHost() {
    return this.host;
  }

  public FlumeNodeStatus setHost(String host) {
    this.host = host;
    return this;
  }

  public void unsetHost() {
    this.host = null;
  }

  /** Returns true if field host is set (has been asigned a value) and false otherwise */
  public boolean isSetHost() {
    return this.host != null;
  }

  public void setHostIsSet(boolean value) {
    if (!value) {
      this.host = null;
    }
  }

  public String getPhysicalNode() {
    return this.physicalNode;
  }

  public FlumeNodeStatus setPhysicalNode(String physicalNode) {
    this.physicalNode = physicalNode;
    return this;
  }

  public void unsetPhysicalNode() {
    this.physicalNode = null;
  }

  /** Returns true if field physicalNode is set (has been asigned a value) and false otherwise */
  public boolean isSetPhysicalNode() {
    return this.physicalNode != null;
  }

  public void setPhysicalNodeIsSet(boolean value) {
    if (!value) {
      this.physicalNode = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case STATE:
      if (value == null) {
        unsetState();
      } else {
        setState((com.cloudera.flume.conf.thrift.FlumeNodeState)value);
      }
      break;

    case VERSION:
      if (value == null) {
        unsetVersion();
      } else {
        setVersion((Long)value);
      }
      break;

    case LASTSEEN:
      if (value == null) {
        unsetLastseen();
      } else {
        setLastseen((Long)value);
      }
      break;

    case HOST:
      if (value == null) {
        unsetHost();
      } else {
        setHost((String)value);
      }
      break;

    case PHYSICAL_NODE:
      if (value == null) {
        unsetPhysicalNode();
      } else {
        setPhysicalNode((String)value);
      }
      break;

    }
  }

  public void setFieldValue(int fieldID, Object value) {
    setFieldValue(_Fields.findByThriftIdOrThrow(fieldID), value);
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case STATE:
      return getState();

    case VERSION:
      return new Long(getVersion());

    case LASTSEEN:
      return new Long(getLastseen());

    case HOST:
      return getHost();

    case PHYSICAL_NODE:
      return getPhysicalNode();

    }
    throw new IllegalStateException();
  }

  public Object getFieldValue(int fieldId) {
    return getFieldValue(_Fields.findByThriftIdOrThrow(fieldId));
  }

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    switch (field) {
    case STATE:
      return isSetState();
    case VERSION:
      return isSetVersion();
    case LASTSEEN:
      return isSetLastseen();
    case HOST:
      return isSetHost();
    case PHYSICAL_NODE:
      return isSetPhysicalNode();
    }
    throw new IllegalStateException();
  }

  public boolean isSet(int fieldID) {
    return isSet(_Fields.findByThriftIdOrThrow(fieldID));
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof FlumeNodeStatus)
      return this.equals((FlumeNodeStatus)that);
    return false;
  }

  public boolean equals(FlumeNodeStatus that) {
    if (that == null)
      return false;

    boolean this_present_state = true && this.isSetState();
    boolean that_present_state = true && that.isSetState();
    if (this_present_state || that_present_state) {
      if (!(this_present_state && that_present_state))
        return false;
      if (!this.state.equals(that.state))
        return false;
    }

    boolean this_present_version = true;
    boolean that_present_version = true;
    if (this_present_version || that_present_version) {
      if (!(this_present_version && that_present_version))
        return false;
      if (this.version != that.version)
        return false;
    }

    boolean this_present_lastseen = true;
    boolean that_present_lastseen = true;
    if (this_present_lastseen || that_present_lastseen) {
      if (!(this_present_lastseen && that_present_lastseen))
        return false;
      if (this.lastseen != that.lastseen)
        return false;
    }

    boolean this_present_host = true && this.isSetHost();
    boolean that_present_host = true && that.isSetHost();
    if (this_present_host || that_present_host) {
      if (!(this_present_host && that_present_host))
        return false;
      if (!this.host.equals(that.host))
        return false;
    }

    boolean this_present_physicalNode = true && this.isSetPhysicalNode();
    boolean that_present_physicalNode = true && that.isSetPhysicalNode();
    if (this_present_physicalNode || that_present_physicalNode) {
      if (!(this_present_physicalNode && that_present_physicalNode))
        return false;
      if (!this.physicalNode.equals(that.physicalNode))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(FlumeNodeStatus other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    FlumeNodeStatus typedOther = (FlumeNodeStatus)other;

    lastComparison = Boolean.valueOf(isSetState()).compareTo(isSetState());
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = TBaseHelper.compareTo(state, typedOther.state);
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = Boolean.valueOf(isSetVersion()).compareTo(isSetVersion());
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = TBaseHelper.compareTo(version, typedOther.version);
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = Boolean.valueOf(isSetLastseen()).compareTo(isSetLastseen());
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = TBaseHelper.compareTo(lastseen, typedOther.lastseen);
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = Boolean.valueOf(isSetHost()).compareTo(isSetHost());
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = TBaseHelper.compareTo(host, typedOther.host);
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = Boolean.valueOf(isSetPhysicalNode()).compareTo(isSetPhysicalNode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = TBaseHelper.compareTo(physicalNode, typedOther.physicalNode);
    if (lastComparison != 0) {
      return lastComparison;
    }
    return 0;
  }

  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) { 
        break;
      }
      _Fields fieldId = _Fields.findByThriftId(field.id);
      if (fieldId == null) {
        TProtocolUtil.skip(iprot, field.type);
      } else {
        switch (fieldId) {
          case STATE:
            if (field.type == TType.I32) {
              this.state = com.cloudera.flume.conf.thrift.FlumeNodeState.findByValue(iprot.readI32());
            } else { 
              TProtocolUtil.skip(iprot, field.type);
            }
            break;
          case VERSION:
            if (field.type == TType.I64) {
              this.version = iprot.readI64();
              setVersionIsSet(true);
            } else { 
              TProtocolUtil.skip(iprot, field.type);
            }
            break;
          case LASTSEEN:
            if (field.type == TType.I64) {
              this.lastseen = iprot.readI64();
              setLastseenIsSet(true);
            } else { 
              TProtocolUtil.skip(iprot, field.type);
            }
            break;
          case HOST:
            if (field.type == TType.STRING) {
              this.host = iprot.readString();
            } else { 
              TProtocolUtil.skip(iprot, field.type);
            }
            break;
          case PHYSICAL_NODE:
            if (field.type == TType.STRING) {
              this.physicalNode = iprot.readString();
            } else { 
              TProtocolUtil.skip(iprot, field.type);
            }
            break;
        }
        iprot.readFieldEnd();
      }
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(TProtocol oprot) throws TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.state != null) {
      oprot.writeFieldBegin(STATE_FIELD_DESC);
      oprot.writeI32(this.state.getValue());
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(VERSION_FIELD_DESC);
    oprot.writeI64(this.version);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(LASTSEEN_FIELD_DESC);
    oprot.writeI64(this.lastseen);
    oprot.writeFieldEnd();
    if (this.host != null) {
      oprot.writeFieldBegin(HOST_FIELD_DESC);
      oprot.writeString(this.host);
      oprot.writeFieldEnd();
    }
    if (this.physicalNode != null) {
      oprot.writeFieldBegin(PHYSICAL_NODE_FIELD_DESC);
      oprot.writeString(this.physicalNode);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("FlumeNodeStatus(");
    boolean first = true;

    sb.append("state:");
    if (this.state == null) {
      sb.append("null");
    } else {
      sb.append(this.state);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("version:");
    sb.append(this.version);
    first = false;
    if (!first) sb.append(", ");
    sb.append("lastseen:");
    sb.append(this.lastseen);
    first = false;
    if (!first) sb.append(", ");
    sb.append("host:");
    if (this.host == null) {
      sb.append("null");
    } else {
      sb.append(this.host);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("physicalNode:");
    if (this.physicalNode == null) {
      sb.append("null");
    } else {
      sb.append(this.physicalNode);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }

}

