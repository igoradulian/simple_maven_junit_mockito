package org.demo.dao;

import jakarta.persistence.TypedQuery;
import org.demo.entity.CoffeeOrder;
import org.demo.entity.Drink;
import org.demo.util.ConnectionFactory;

/**
 * @author Igor Adulyan
 */
public class CoffeeOrderDAOImpl implements CoffeeOrderDAO{

    ConnectionFactory connectionFactory = ConnectionFactory.GET_SESSION.getInstance();

    @Override
    public void coffeeOrderSave(CoffeeOrder coffeeOrder) {
        connectionFactory.getSession().persist(coffeeOrder);
    }

    @Override
    public CoffeeOrder findCoffeeOrder(int id) {
        TypedQuery<CoffeeOrder> typedQuery =connectionFactory.getSession().getNamedQuery("findCoffeeOrderById");
        typedQuery.setParameter("id", id);
        CoffeeOrder coffeeOrder = typedQuery.getSingleResult();
        return coffeeOrder;
    }

    @Override
    public void coffeeOrderUpdate(CoffeeOrder coffeeOrder) {
        connectionFactory.getSession().merge(coffeeOrder);
    }

    @Override
    public void coffeeOrderDelete(CoffeeOrder coffeeOrder) {
        connectionFactory.getSession().delete(coffeeOrder);
    }
}
