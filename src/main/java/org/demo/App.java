package org.demo;

/**
 * @author Igor Adulyan
 */


import org.demo.dao.DrinkDAO;
import org.demo.dao.DrinkDAOImpl;
import org.demo.entity.CoffeeOrder;
import org.demo.entity.Drink;
import org.demo.util.ConnectionFactory;
import org.demo.util.CrateTablesRoutine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Main benac is initial set up
 * for sub-demo projects.
 * You can use this branch as
 * skeleton for your own projects
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //CrateTablesRoutine.createTables();

        ConnectionFactory connectionFactory = ConnectionFactory.GET_SESSION.getInstance();

        Drink drink = new Drink();
        drink.setDrinkName("Coffee Latte");
        drink.setDrinkDescription("Kenya Dark roast");
        drink.setDrinkPrice(3.99);

        DrinkDAO drinkDAO = new DrinkDAOImpl();
        drinkDAO.saveDrink(drink);

        connectionFactory.closeSession();

    }
}

