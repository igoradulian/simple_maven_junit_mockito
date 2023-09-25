package org.demo.dao;

import org.demo.entity.Drink;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Igor Adulyan
 */
public interface DrinkDAO {


    public void saveDrink(Drink drink) throws ClassNotFoundException, SQLException;
    public Drink findDrinkById(int id) throws ClassNotFoundException, SQLException;
    public Drink findDrinkByName(String name) throws ClassNotFoundException, SQLException;

    public List<Drink> getAllDrinks() throws ClassNotFoundException, SQLException;

    public void updateDrink(Drink drink) throws ClassNotFoundException, SQLException;

}
