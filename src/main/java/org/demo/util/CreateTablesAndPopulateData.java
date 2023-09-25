package org.demo.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Igor Adulyan
 */

/**
 * Basic example of
 * JDBC connectivity.
 * database connectivity
 */
public class CreateTablesAndPopulateData {


        public static void createDb() throws ClassNotFoundException, SQLException {
            Connection connection = ConnectionToDB.connectToDB();
            Statement statement = connection.createStatement();

            statement.execute("CREATE SCHEMA IF NOT EXISTS african_coffee");
        }

        public static void createTable() throws ClassNotFoundException, SQLException {
            Connection connection = ConnectionToDB.connectToDB();


            try {
                Statement statement = connection.createStatement();

             /*   statement.execute("DROP TABLE IF EXISTS Drink;" +
                "CREATE TABLE Drink(`id` int NOT NULL AUTO_INCREMENT,`name` VARCHAR(255),`description` VARCHAR(255),`price` decimal(10,2),`quantity` INT(11),PRIMARY KEY (id));");*/


                statement.execute("INSERT INTO Drink(name,description, price, quantity ) VALUES ( " +
                        "'Coffee Latte'," +
                        "'Coffee Latte with whole milk'," +
                        "3.99,"+
                        "1)" );

                statement.execute("INSERT INTO Drink(name,description, price, quantity ) VALUES ( " +
                        "'Espresso'," +
                        "'Dark roast Kenyan coffee'," +
                        "2.99,"+
                        "1)" );

                statement.execute("INSERT INTO Drink(name,description, price, quantity ) VALUES ( " +
                        "'Americano'," +
                        "'Dark roast Columbian coffee'," +
                        "3.59,"+
                        "1)" );

                statement.execute("INSERT INTO Drink(name,description, price, quantity ) VALUES ( " +
                        "'Americano'," +
                        "'Dark roast Columbian coffee'," +
                        "3.59,"+
                        "1)" );


                statement.execute("INSERT INTO Drink(name,description, price, quantity ) VALUES ( " +
                        "'Caffe Mocha'," +
                        "'Medium Roast Kenyan coffee'," +
                        "4.19,"+
                        "1)" );

                statement.close();

            }catch (Exception e)
            {
                e.printStackTrace();
                e.getCause();
            }

            connection.close();
        }

        public static void cleanUpTables() throws ClassNotFoundException, SQLException {
            Connection connection = ConnectionToDB.connectToDB();
            Statement statement = connection.createStatement();

            statement.execute("DELETE from drink");
            statement.execute("DELETE from coffee_order");

            connection.close();

        }
}
