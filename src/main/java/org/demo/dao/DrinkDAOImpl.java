package org.demo.dao;

import org.demo.entity.Drink;
import org.demo.sql.DrinkUpdate;
import org.demo.sql.FindDrink;
import org.demo.sql.SaveDrink;
import org.demo.util.ConnectionToDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Igor Adulyan
 */
public class DrinkDAOImpl implements DrinkDAO{
    @Override
    public void saveDrink(Drink drink) throws ClassNotFoundException, SQLException {
        Connection connection = ConnectionToDB.connectToDB();
        PreparedStatement preparedStatement = connection.prepareStatement(SaveDrink.ADD_DRINK.getSql());
        preparedStatement.setString(1, drink.getName());
        preparedStatement.setString(2, drink.getDescription());
        preparedStatement.setDouble(3, drink.getPrice());
        preparedStatement.executeUpdate();

        connection.close();
    }

    @Override
    public Drink findDrinkById(int id) throws ClassNotFoundException, SQLException {
        Connection connection = ConnectionToDB.connectToDB();
        PreparedStatement preparedStatement = connection.prepareStatement(FindDrink.BY_ID.getSql());
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Drink drink = new Drink();
        while (resultSet.next()){
            drink.setId(resultSet.getInt("id"));
            drink.setName(resultSet.getString("name"));
            drink.setDescription(resultSet.getString("description"));
        }


        connection.close();
        return drink;
    }

    @Override
    public Drink findDrinkByName(String name) throws ClassNotFoundException, SQLException {
        Connection connection = ConnectionToDB.connectToDB();
        PreparedStatement preparedStatement = connection.prepareStatement(FindDrink.BY_NAME.getSql());
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        Drink drink = new Drink();
        while (resultSet.next()){
            drink.setId(resultSet.getInt("id"));
            drink.setName(resultSet.getString("name"));
            drink.setDescription(resultSet.getString("description"));
        }


        connection.close();
        return drink;
    }

    @Override
    public List<Drink> getAllDrinks() throws ClassNotFoundException, SQLException {
        Connection connection = ConnectionToDB.connectToDB();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(FindDrink.ALL.getSql());
        List<Drink> drinkList = new ArrayList<>();
        while (resultSet.next()){
            Drink drink = new Drink();
            drink.setId(resultSet.getInt("id"));
            drink.setName(resultSet.getString("name"));
            drink.setDescription(resultSet.getString("description"));
            drinkList.add(drink);
        }


        connection.close();
        return drinkList;
    }

    @Override
    public void updateDrink(Drink drink) throws ClassNotFoundException, SQLException {
        Connection connection = ConnectionToDB.connectToDB();
        PreparedStatement preparedStatement = connection.prepareStatement(FindDrink.BY_NAME.getSql());
        preparedStatement.setString(1, drink.getName());
        ResultSet resultSet = preparedStatement.executeQuery();
        Drink savedDrink = new Drink();
        while (resultSet.next()){
            savedDrink.setId(resultSet.getInt("id"));
            savedDrink.setName(resultSet.getString("name"));
            savedDrink.setDescription(resultSet.getString("description"));
            savedDrink.setPrice(resultSet.getDouble("price"));
        }

        savedDrink.setPrice(drink.getPrice());
        savedDrink.setName(drink.getName());
        savedDrink.setDescription(drink.getDescription());

        PreparedStatement prepStatment = connection.prepareStatement(DrinkUpdate.DRINK_UPDATE.getSql());
        prepStatment.setString(1, savedDrink.getName());
        prepStatment.setString(2, savedDrink.getDescription());
        prepStatment.setDouble(3, savedDrink.getPrice());
        prepStatment.setInt(4, savedDrink.getId());
        prepStatment.executeUpdate();

        connection.close();
    }
}
