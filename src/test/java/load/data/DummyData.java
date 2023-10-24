package load.data;

import org.demo.dao.CoffeeOrderDAO;
import org.demo.dao.CoffeeOrderDAOImpl;
import org.demo.dao.DrinkDAO;
import org.demo.dao.DrinkDAOImpl;
import org.demo.entity.Drink;
import org.demo.util.ConnectionFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author Igor Adulyan
 */
public class DummyData {


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
    @CsvSource({
            "Coffee Latte,Kenya Dark roast,3.99",
            "Black Coffee,Tanzanian Medium roast, 2.99"

    })
    public void pushDummyDataToDB(String drinkName, String drinkDescription, String drinkPrice) {
        Drink drink = new Drink();
        drink.setDrinkName(drinkName);
        drink.setDrinkDescription(drinkDescription);
        drink.setDrinkPrice(Double.parseDouble(drinkPrice));

        drinkDAO.saveDrink(drink);

    }

}
