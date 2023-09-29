package org.demo.util;

import org.demo.sql.FindDrink;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Igor Adulyan
 */
public class ConnectionToDB {
    //Database user name
    private static final String USERNAME = "igor";

    //Database password
    private static final String PASSWORD = "password";

    public static Connection connectToDB() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/african_coffee", USERNAME, PASSWORD);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
