package org.demo.dao;

import org.demo.entity.CoffeeOrder;

import java.sql.SQLException;

/**
 * @author Igor Adulyan
 */
public interface OrderDAO {

    public void saveOrder(CoffeeOrder coffeeOrder) throws ClassNotFoundException, SQLException;
    public CoffeeOrder updateOrder(CoffeeOrder coffeeOrder) throws ClassNotFoundException, SQLException;

    public CoffeeOrder findOrderByName(String name) throws ClassNotFoundException, SQLException;


}
