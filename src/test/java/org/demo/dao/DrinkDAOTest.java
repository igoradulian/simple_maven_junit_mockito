package org.demo.dao;

import org.demo.entity.Drink;
import org.demo.util.CreateTablesAndPopulateData;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Igor Adulyan
 */

/**
 * This test created to
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Drink CRUD test")
public class DrinkDAOTest {

    static DrinkDAO drinkDAO;


    @BeforeAll
    @DisplayName("Initialize DrinkDAO")
    public static void initAll()
    {
        drinkDAO = new DrinkDAOImpl();

    }


    @Test
    @DisplayName("Save drink to DB")
    @Order(1)
    public void saveDrinkTest() throws SQLException, ClassNotFoundException {
        Drink drink = new Drink();
        drink.setName("Coffee");
        drink.setDescription("Dark roast");
        drink.setPrice(2.33);

        drinkDAO.saveDrink(drink);

        Assertions.assertNotNull(drinkDAO.findDrinkByName("Coffee"));
    }


    @Test
    @Order(2)
    @DisplayName("Find drinks by coffee name")
    public void findADrinksByNameTest() throws SQLException, ClassNotFoundException {

        Drink drink = makeInstanceOfDrink();
        Drink actualDrink = drinkDAO.findDrinkByName("Coffee");

        Assertions.assertEquals(drink.getName(), actualDrink.getName());
    }

    @Test
    @Order(3)
    @DisplayName("Find drinks by coffee ID")
    public void findDrinksByIdTest() throws SQLException, ClassNotFoundException {

        Drink drink = makeInstanceOfDrink();
        Drink actualDrink = drinkDAO.findDrinkById(drinkDAO.findDrinkByName("Coffee").getId());

        Assertions.assertEquals(drink.getName(), actualDrink.getName());
    }

    @Test
    @Order(3)
    @DisplayName("Find all coffee drinks from DB and return them as List")
    public void findAAllDrinksTest() throws SQLException, ClassNotFoundException {

       List<Drink> drinkList = drinkDAO.getAllDrinks();
        Assertions.assertEquals(1, drinkList.size());
    }


    @Test
    @Order(4)
    @DisplayName("Update drink's data")
    public void updateDrinkTest() throws SQLException, ClassNotFoundException {

        Drink drink = drinkDAO.findDrinkByName("Coffee");
        drink.setDescription("Coffee with Milk");
        drinkDAO.updateDrink(drink);

        Drink drinkActual = drinkDAO.findDrinkByName("Coffee");
        Assertions.assertEquals("Coffee with Milk", drinkActual.getDescription());

        Assertions.assertEquals(drink, drinkActual);

    }




    private Drink makeInstanceOfDrink()
    {

        Drink drink = new Drink();
        drink.setName("Coffee");
        drink.setDescription("Dark roast");
        drink.setPrice(2.33);

        return drink;
    }


    @AfterAll
    public static void clean() throws SQLException, ClassNotFoundException {
        CreateTablesAndPopulateData.cleanUpTables();
    }


}
