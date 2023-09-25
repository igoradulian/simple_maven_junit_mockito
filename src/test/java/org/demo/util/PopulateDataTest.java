package org.demo.util;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Igor Adulyan
 */
public class PopulateDataTest {

    @Test
    public void connectToDbTest() throws ClassNotFoundException, SQLException {
        Connection connection = ConnectionToDB.connectToDB();
        Assertions.assertNotNull(connection.getMetaData());
    }

    @Test
    public void createTableTest() throws ClassNotFoundException, SQLException {
        CreateTablesAndPopulateData.createDb();
        CreateTablesAndPopulateData.createTable();
    }

    @Test
    public void h2DBTest() throws ClassNotFoundException {
        ConnectionH2DB.connectToDB();
    }

    @AfterAll
    public static void clean() throws ClassNotFoundException, SQLException {
        ConnectionToDB.connectToDB().close();
    }

}
