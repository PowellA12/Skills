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
import org.inspirenxe.skills.impl.database.generated.tables.records.SqliteSequenceRecord;
import org.jooq.Field;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

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
public class SqliteSequence extends TableImpl<SqliteSequenceRecord> {

  /**
   * The reference instance of <code>sqlite_sequence</code>
   */
  public static final SqliteSequence SQLITE_SEQUENCE = new SqliteSequence();
  private static final long serialVersionUID = 1321131924;
  /**
   * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can
   * be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
   */
  @java.lang.Deprecated
  public final TableField<SqliteSequenceRecord, Object> NAME = createField("name", org.jooq.impl.DefaultDataType.getDefaultDataType(""), this, "");
  /**
   * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can
   * be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
   */
  @java.lang.Deprecated
  public final TableField<SqliteSequenceRecord, Object> SEQ = createField("seq", org.jooq.impl.DefaultDataType.getDefaultDataType(""), this, "");

  /**
   * Create a <code>sqlite_sequence</code> table reference
   */
  public SqliteSequence() {
    this(DSL.name("sqlite_sequence"), null);
  }

  /**
   * Create an aliased <code>sqlite_sequence</code> table reference
   */
  public SqliteSequence(String alias) {
    this(DSL.name(alias), SQLITE_SEQUENCE);
  }

  /**
   * Create an aliased <code>sqlite_sequence</code> table reference
   */
  public SqliteSequence(Name alias) {
    this(alias, SQLITE_SEQUENCE);
  }

  private SqliteSequence(Name alias, Table<SqliteSequenceRecord> aliased) {
    this(alias, aliased, null);
  }

  private SqliteSequence(Name alias, Table<SqliteSequenceRecord> aliased, Field<?>[] parameters) {
    super(alias, null, aliased, parameters, "");
  }

  /**
   * The class holding records for this type
   */
  @Override
  public Class<SqliteSequenceRecord> getRecordType() {
    return SqliteSequenceRecord.class;
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
  public SqliteSequence as(String alias) {
    return new SqliteSequence(DSL.name(alias), this);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public SqliteSequence as(Name alias) {
    return new SqliteSequence(alias, this);
  }

  /**
   * Rename this table
   */
  @Override
  public SqliteSequence rename(String name) {
    return new SqliteSequence(DSL.name(name), null);
  }

  /**
   * Rename this table
   */
  @Override
  public SqliteSequence rename(Name name) {
    return new SqliteSequence(name, null);
  }
}
