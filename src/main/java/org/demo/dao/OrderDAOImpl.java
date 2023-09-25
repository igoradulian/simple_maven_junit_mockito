package org.demo.dao;

import org.demo.entity.CoffeeOrder;
import org.demo.sql.DrinkUpdate;
import org.demo.sql.OrderCrud;
import org.demo.util.ConnectionToDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Igor Adulyan
 */
public class OrderDAOImpl implements OrderDAO{

    @Override
    public void saveOrder(CoffeeOrder coffeeOrder) throws ClassNotFoundException, SQLException {
        Connection connection = ConnectionToDB.connectToDB();
        PreparedStatement preparedStatement = connection.prepareStatement(OrderCrud.ADD_ORDER.getSql());
        preparedStatement.setInt(1, coffeeOrder.getDrinkId());
        preparedStatement.setInt(2, coffeeOrder.getQuantity());
        preparedStatement.setString(3, coffeeOrder.getNameOnOrder());
        preparedStatement.executeUpdate();

        connection.close();
    }

    @Override
    public CoffeeOrder updateOrder(CoffeeOrder coffeeOrder) throws ClassNotFoundException, SQLException {
        Connection connection = ConnectionToDB.connectToDB();
        PreparedStatement preparedStatement = connection.prepareStatement(OrderCrud.UPDATE_ORDER.getSql());
        preparedStatement.setInt(1, coffeeOrder.getQuantity());
        preparedStatement.setInt(2, coffeeOrder.getId());

        ResultSet resultSet = preparedStatement.executeQuery();
        CoffeeOrder savedOrder = new CoffeeOrder();
        while (resultSet.next()){
            savedOrder.setId(resultSet.getInt("id"));
            savedOrder.setDrinkId(resultSet.getInt("drink_id"));
            savedOrder.setQuantity(resultSet.getInt("quantity"));
        }

        savedOrder.setQuantity(coffeeOrder.getQuantity());

        PreparedStatement prepStatment = connection.prepareStatement(DrinkUpdate.DRINK_UPDATE.getSql());
        prepStatment.setInt(1, savedOrder.getQuantity());
        prepStatment.setInt(2, savedOrder.getId());
        prepStatment.executeUpdate();

        connection.close();


        return savedOrder;
    }

    @Override
    public CoffeeOrder findOrderByName(String name) throws ClassNotFoundException, SQLException {
        Connection connection = ConnectionToDB.connectToDB();
        PreparedStatement preparedStatement = connection
                .prepareStatement(OrderCrud.FIND_ORDER_BY_NAME.getSql());
        preparedStatement.setString(1, name);

        ResultSet resultSet = preparedStatement.executeQuery();
        CoffeeOrder coffeeOrder = new CoffeeOrder();
        while (resultSet.next()){
            coffeeOrder.setId(resultSet.getInt("id"));
            coffeeOrder.setDrinkId(resultSet.getInt("drink_id"));
            coffeeOrder.setQuantity(resultSet.getInt("quantity"));
            coffeeOrder.setNameOnOrder(resultSet.getString("name_on_order"));
        }
        return coffeeOrder;
    }
}
