package org.demo.dao;

import org.demo.entity.CoffeeOrder;
import org.demo.entity.Drink;

/**
 * @author Igor Adulyan
 */
public interface DrinkDAO {

    public void saveDrink(Drink drink);
    public Drink findDrinkByName(String name);
    public void updateDrink(Drink drink);
    public Drink findDrinkByCoffeeOrder(CoffeeOrder coffeeOrder);

}
