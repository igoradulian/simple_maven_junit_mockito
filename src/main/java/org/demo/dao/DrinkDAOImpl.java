package org.demo.dao;

import jakarta.persistence.TypedQuery;
import org.demo.entity.CoffeeOrder;
import org.demo.entity.Drink;
import org.demo.util.ConnectionFactory;
import org.hibernate.Session;

/**
 * @author Igor Adulyan
 */
public class DrinkDAOImpl implements DrinkDAO{

    ConnectionFactory connectionFactory = ConnectionFactory.GET_SESSION.getInstance();
    @Override
    public void saveDrink(Drink drink) {
        connectionFactory.getSession().persist(drink);
    }

    /**
     * @apiNote for named
     * query findCoffeeDrinkByName
     * must use getNamedQuery method
     * @param name
     * @return
     */
    @Override
    public Drink findDrinkByName(String name) {

        TypedQuery<Drink> typedQuery =connectionFactory.getSession().getNamedQuery("findCoffeeDrinkByName");
        typedQuery.setParameter("name", name);
        Drink drink = typedQuery.getSingleResult();
        return drink;
    }

    @Override
    public void updateDrink(Drink drink) {
       connectionFactory.getSession().merge(drink);
    }

    @Override
    public Drink findDrinkByCoffeeOrder(CoffeeOrder coffeeOrder) {
        return null;
    }
}
