package org.demo.dao;

import org.demo.entity.Drink;
import org.demo.util.ConnectionFactory;
import org.junit.jupiter.api.*;

/**
 * @author Igor Adulyan
 */

@TestMethodOrder(MethodOrderer.MethodName.class)
@DisplayName("DrinkDAO test")
public class DrinkDAOTest {

    static ConnectionFactory connectionFactory;
    static DrinkDAO drinkDAO;

    @BeforeAll
    public static void init()
    {
        connectionFactory = ConnectionFactory.GET_SESSION.getInstance();
        drinkDAO = new DrinkDAOImpl();
    }

    @Test
    @Order(1)
    public void testDrinkSave()
    {
        Drink drink = new Drink();
        drink.setDrinkName("Coffee Latte");
        drink.setDrinkDescription("Kenya Dark roast");
        drink.setDrinkPrice(3.99);

        drinkDAO.saveDrink(drink);

        Drink actualDrink = drinkDAO.findDrinkByName("Coffee Latte");
        Assertions.assertEquals("Coffee Latte", actualDrink.getDrinkName());
    }

    @Test
    @Order(2)
    public void testFindDrinkByName()
    {
        Drink actualDrink = drinkDAO.findDrinkByName("Coffee Latte");
        Assertions.assertEquals("Coffee Latte", actualDrink.getDrinkName());
    }

    @Test
    @Order(3)
    public void testUpdateDrink()
    {
        drinkDAO.updateDrink(createDrink());
        Drink actualDrink = drinkDAO.findDrinkByName("Black Coffee");

        Assertions.assertEquals(actualDrink.getDrinkDescription(),"Medium roast");
    }


    @AfterAll
    public static void cleanAfterAll()
    {
        connectionFactory.closeSession();
    }

    private Drink createDrink(){
        Drink drink = new Drink();
        drink.setDrinkPrice(4.99);
        drink.setDrinkName("Black Coffee");
        drink.setDrinkDescription("Medium roast");

        return drink;
    }
}
