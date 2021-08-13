/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company and XSK contributors
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License, v2.0
 * which accompanies this distribution, and is available at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * SPDX-FileCopyrightText: 2021 SAP SE or an SAP affiliate company and XSK contributors
 * SPDX-License-Identifier: Apache-2.0
 */
package com.sap.xsk.hdb.ds.itest.hdbsynonym;

import static org.junit.Assert.assertEquals;

import com.sap.xsk.hdb.ds.api.XSKDataStructuresException;
import com.sap.xsk.hdb.ds.facade.IXSKHDBCoreFacade;
import com.sap.xsk.hdb.ds.facade.XSKHDBCoreFacade;
import com.sap.xsk.hdb.ds.itest.model.JDBCModel;
import com.sap.xsk.hdb.ds.itest.module.XSKHDBTestModule;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.eclipse.dirigible.commons.config.StaticObjects;
import org.eclipse.dirigible.core.scheduler.api.SynchronizationException;
import org.eclipse.dirigible.repository.local.LocalResource;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testcontainers.containers.PostgreSQLContainer;

public class XSKHDBSynonymParserPostgreSQLITTest {
  private static PostgreSQLContainer jdbcContainer;
  private static DataSource datasource;
  private static IXSKHDBCoreFacade facade;


  @BeforeClass
  public static void setUp() throws SQLException {
    jdbcContainer =
        new PostgreSQLContainer<>("postgres:alpine");
    jdbcContainer.start();
    JDBCModel model = new JDBCModel(jdbcContainer.getDriverClassName(), jdbcContainer.getJdbcUrl(), jdbcContainer.getUsername(),
        jdbcContainer.getPassword());
    XSKHDBTestModule xskhdbTestModule = new XSKHDBTestModule(model);
    xskhdbTestModule.configure();
    datasource = (DataSource) StaticObjects.get(StaticObjects.DATASOURCE);
    facade = new XSKHDBCoreFacade();
  }

  @AfterClass
  public static void cleanUp() {
    jdbcContainer.stop();
  }

  @Test
  public void testHDBSynonymCreateNotSupportedError() throws IOException, XSKDataStructuresException, SynchronizationException, SQLException {
    try (Connection connection = datasource.getConnection();
        Statement stmt = connection.createStatement()) {

      stmt.executeUpdate("create table \"public\".\"hdbsynonym-itest::SampleTable\"(COLUMN1 integer,COLUMN2 integer)");
      LocalResource resource = XSKHDBTestModule.getResources("/usr/local/target/dirigible/repository/root",
          "/registry/public/hdbsynonym-itest/SampleHanaXSClassicSynonym.hdbsynonym",
          "/hdbsynonym-itest/SampleHanaXSClassicSynonym.hdbsynonym");

      this.facade.handleResourceSynchronization(resource);
      this.facade.updateEntities();

      List<String> synonyms = new ArrayList<>();
      ResultSet rs = stmt.executeQuery("SELECT  * FROM  pg_class WHERE  relname = 'hdbsynonym-itest::SampleHanaXSClassicSynonym'");
      while (rs.next()) {
        synonyms.add(rs.getString("hdbsynonym-itest::SampleHanaXSClassicSynonym"));
      }
      assertEquals(0, synonyms.size());
      stmt.executeUpdate("DROP TABLE \"public\".\"hdbsynonym-itest::SampleTable\"");
    }
  }
}