package org.demo.dao;

import org.demo.entity.CoffeeOrder;
import org.demo.entity.Drink;
import org.demo.util.CreateTablesAndPopulateData;
import org.junit.jupiter.api.*;

import java.sql.SQLException;

/**
 * @author Igor Adulyan
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Order CRUD test")
public class OrderDAOTest {


    static DrinkDAO drinkDAO;
    static OrderDAO orderDAO;

    @BeforeAll
    @DisplayName("Initialize DrinkDAO and OrderDAO")
    public static void initAll()
    {
        drinkDAO = new DrinkDAOImpl();
        orderDAO = new OrderDAOImpl();

    }

    @Order(1)
    @DisplayName("Save Order")
    @Test
    public void orderSaveTest() throws SQLException, ClassNotFoundException {
        Drink drink = makeInstanceOfDrink();
        drinkDAO.saveDrink(drink);
        CoffeeOrder coffeeOrder = new CoffeeOrder();
        coffeeOrder.setDrinkId(drinkDAO.findDrinkByName("Coffee").getId());
        coffeeOrder.setQuantity(1);
        coffeeOrder.setNameOnOrder("John");
        orderDAO.saveOrder(coffeeOrder);

        CoffeeOrder actualCoffeeOrder = orderDAO.findOrderByName("John");

        Assertions.assertEquals("John", actualCoffeeOrder.getNameOnOrder());

    }

    private Drink makeInstanceOfDrink()
    {

        Drink drink = new Drink();
        drink.setName("Coffee");
        drink.setDescription("Dark roast");
        drink.setPrice(2.33);

        return drink;
    }





}
