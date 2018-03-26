/*
 * This file is part of Skills, licensed under the MIT License (MIT).
 *
 * Copyright (c) InspireNXE
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
/*
 * This file is generated by jOOQ.
 */
package org.inspirenxe.skills.impl.database.generated.tables;


import org.inspirenxe.skills.impl.database.generated.DefaultSchema;
import org.inspirenxe.skills.impl.database.generated.Indexes;
import org.inspirenxe.skills.impl.database.generated.Keys;
import org.inspirenxe.skills.impl.database.generated.tables.records.TblSkillTypeRecord;
import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

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
public class TblSkillType extends TableImpl<TblSkillTypeRecord> {

  /**
   * The reference instance of <code>tbl_skill_type</code>
   */
  public static final TblSkillType TBL_SKILL_TYPE = new TblSkillType();
  private static final long serialVersionUID = -1632466685;
  /**
   * The column <code>tbl_skill_type.id</code>.
   */
  public final TableField<TblSkillTypeRecord, Integer> ID =
      createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");
  /**
   * The column <code>tbl_skill_type.created</code>.
   */
  public final TableField<TblSkillTypeRecord, Timestamp> CREATED = createField("created", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false)
      .defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");
  /**
   * The column <code>tbl_skill_type.name</code>.
   */
  public final TableField<TblSkillTypeRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

  /**
   * Create a <code>tbl_skill_type</code> table reference
   */
  public TblSkillType() {
    this(DSL.name("tbl_skill_type"), null);
  }

  /**
   * Create an aliased <code>tbl_skill_type</code> table reference
   */
  public TblSkillType(String alias) {
    this(DSL.name(alias), TBL_SKILL_TYPE);
  }

  /**
   * Create an aliased <code>tbl_skill_type</code> table reference
   */
  public TblSkillType(Name alias) {
    this(alias, TBL_SKILL_TYPE);
  }

  private TblSkillType(Name alias, Table<TblSkillTypeRecord> aliased) {
    this(alias, aliased, null);
  }

  private TblSkillType(Name alias, Table<TblSkillTypeRecord> aliased, Field<?>[] parameters) {
    super(alias, null, aliased, parameters, "");
  }

  /**
   * The class holding records for this type
   */
  @Override
  public Class<TblSkillTypeRecord> getRecordType() {
    return TblSkillTypeRecord.class;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Schema getSchema() {
    return DefaultSchema.DEFAULT_SCHEMA;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Index> getIndexes() {
    return Arrays.<Index>asList(Indexes.TBL_SKILL_TYPE_NAME_UINDEX);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Identity<TblSkillTypeRecord, Integer> getIdentity() {
    return Keys.IDENTITY_TBL_SKILL_TYPE;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public UniqueKey<TblSkillTypeRecord> getPrimaryKey() {
    return Keys.PK_TBL_SKILL_TYPE;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<UniqueKey<TblSkillTypeRecord>> getKeys() {
    return Arrays.<UniqueKey<TblSkillTypeRecord>>asList(Keys.PK_TBL_SKILL_TYPE);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public TblSkillType as(String alias) {
    return new TblSkillType(DSL.name(alias), this);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public TblSkillType as(Name alias) {
    return new TblSkillType(alias, this);
  }

  /**
   * Rename this table
   */
  @Override
  public TblSkillType rename(String name) {
    return new TblSkillType(DSL.name(name), null);
  }

  /**
   * Rename this table
   */
  @Override
  public TblSkillType rename(Name name) {
    return new TblSkillType(name, null);
  }
}
