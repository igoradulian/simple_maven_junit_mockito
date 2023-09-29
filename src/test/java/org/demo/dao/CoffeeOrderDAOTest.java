package org.demo.dao;

import org.demo.util.ConnectionFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;

/**
 * @author Igor Adulyan
 */

@TestMethodOrder(MethodOrderer.MethodName.class)
@DisplayName("CoffeeOrderDAO test")
public class CoffeeOrderDAOTest {

    static ConnectionFactory connectionFactory;
    static DrinkDAO drinkDAO;
    static CoffeeOrderDAO coffeeOrderDAO;
    @BeforeAll
    public static void init()
    {
        connectionFactory = ConnectionFactory.GET_SESSION.getInstance();
        drinkDAO = new DrinkDAOImpl();
        coffeeOrderDAO = new CoffeeOrderDAOImpl();
    }


    @ParameterizedTest
    public void testSaveCoffeeOrder()
    {

    }
}
