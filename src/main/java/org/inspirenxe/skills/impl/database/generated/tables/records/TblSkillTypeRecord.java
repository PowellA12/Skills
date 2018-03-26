/*
 * This file is generated by jOOQ.
 */
package org.inspirenxe.skills.impl.database.generated.tables.records;


import org.inspirenxe.skills.impl.database.generated.tables.TblSkillType;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;

import java.sql.Timestamp;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class TblSkillTypeRecord extends UpdatableRecordImpl<TblSkillTypeRecord> implements Record3<Integer, Timestamp, String> {

  private static final long serialVersionUID = 723194109;

  /**
   * Create a detached TblSkillTypeRecord
   */
  public TblSkillTypeRecord() {
    super(TblSkillType.TBL_SKILL_TYPE);
  }

  /**
   * Create a detached, initialised TblSkillTypeRecord
   */
  public TblSkillTypeRecord(Integer id, Timestamp created, String name) {
    super(TblSkillType.TBL_SKILL_TYPE);

    set(0, id);
    set(1, created);
    set(2, name);
  }

  /**
   * Getter for <code>tbl_skill_type.id</code>.
   */
  public Integer getId() {
    return (Integer) get(0);
  }

  /**
   * Setter for <code>tbl_skill_type.id</code>.
   */
  public void setId(Integer value) {
    set(0, value);
  }

  /**
   * Getter for <code>tbl_skill_type.created</code>.
   */
  public Timestamp getCreated() {
    return (Timestamp) get(1);
  }

  /**
   * Setter for <code>tbl_skill_type.created</code>.
   */
  public void setCreated(Timestamp value) {
    set(1, value);
  }

  // -------------------------------------------------------------------------
  // Primary key information
  // -------------------------------------------------------------------------

  /**
   * Getter for <code>tbl_skill_type.name</code>.
   */
  public String getName() {
    return (String) get(2);
  }

  // -------------------------------------------------------------------------
  // Record3 type implementation
  // -------------------------------------------------------------------------

  /**
   * Setter for <code>tbl_skill_type.name</code>.
   */
  public void setName(String value) {
    set(2, value);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Record1<Integer> key() {
    return (Record1) super.key();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Row3<Integer, Timestamp, String> fieldsRow() {
    return (Row3) super.fieldsRow();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Row3<Integer, Timestamp, String> valuesRow() {
    return (Row3) super.valuesRow();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Field<Integer> field1() {
    return TblSkillType.TBL_SKILL_TYPE.ID;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Field<Timestamp> field2() {
    return TblSkillType.TBL_SKILL_TYPE.CREATED;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Field<String> field3() {
    return TblSkillType.TBL_SKILL_TYPE.NAME;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Integer component1() {
    return getId();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Timestamp component2() {
    return getCreated();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String component3() {
    return getName();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Integer value1() {
    return getId();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Timestamp value2() {
    return getCreated();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String value3() {
    return getName();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public TblSkillTypeRecord value1(Integer value) {
    setId(value);
    return this;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public TblSkillTypeRecord value2(Timestamp value) {
    setCreated(value);
    return this;
  }

  // -------------------------------------------------------------------------
  // Constructors
  // -------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override
  public TblSkillTypeRecord value3(String value) {
    setName(value);
    return this;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public TblSkillTypeRecord values(Integer value1, Timestamp value2, String value3) {
    value1(value1);
    value2(value2);
    value3(value3);
    return this;
  }
}
