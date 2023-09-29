package org.demo.dao;

import org.demo.entity.CoffeeOrder;

/**
 * @author Igor Adulyan
 */
public interface CoffeeOrderDAO {

    public void coffeeOrderSave(CoffeeOrder coffeeOrder);
    public CoffeeOrder findCoffeeOrder(int id);

    public void coffeeOrderUpdate(CoffeeOrder coffeeOrder);

    public void coffeeOrderDelete(CoffeeOrder coffeeOrder);
}
