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
package org.inspirenxe.skills.impl.database;

import static com.google.common.base.Preconditions.checkNotNull;

import com.almuradev.toolbox.inject.event.Witness;
import com.almuradev.toolbox.inject.event.WitnessScope;
import com.google.inject.Singleton;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.Order;
import org.spongepowered.api.event.service.ChangeServiceProviderEvent;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.service.sql.SqlService;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

@Singleton
@WitnessScope.Sponge
public final class DatabaseManager implements Witness {

  private final PluginContainer container;
  private final DatabaseConfiguration configuration;
  private SqlService service;

  private DataSource dataSource;

  public DatabaseManager(final PluginContainer container, final SqlService service, final DatabaseConfiguration configuration) {
    this.container = container;
    this.service = service;
    this.configuration = configuration;
  }

  public void createDataSource() throws SQLException {
    this.dataSource = this.service.getDataSource(this.container, this.configuration.getConnectionString());
  }

  public DataSource getDataSource() {
    checkNotNull(this.dataSource, "Data Source has not been initialized yet! (Did you forget to call createDataSource()?)");
    return this.dataSource;
  }

  public Connection getConnection() throws SQLException {
    checkNotNull(this.dataSource, "Data Source has not been initialized yet! (Did you forget to call createDataSource()?)");
    return this.dataSource.getConnection();
  }

  public DSLContext createContext() {
    return DSL.using(this.dataSource, SQLDialect.SQLITE);
  }

  @Listener(order = Order.LAST)
  public void onServiceChange(ChangeServiceProviderEvent event) {
    if (event.getService() == SqlService.class) {
      this.service = (SqlService) event.getNewProvider();

      try {
        this.createDataSource();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
