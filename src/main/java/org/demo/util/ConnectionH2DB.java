package org.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Igor Adulyan
 */
public class ConnectionH2DB {

    private static final String USERNAME = "sa";

    //Database password
    private static final String PASSWORD = "";

    public static Connection connectToDB() throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:mem:test", USERNAME, PASSWORD);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
