package org.demo.entity;

import jakarta.persistence.*;

/**
 * @author Igor Adulyan
 */

@Entity
@NamedQueries({
        @NamedQuery(name = "findCoffeeDrinkByName", query = "from Drink where drinkName=:name")
})
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String drinkName;
    private String drinkDescription;
    private double drinkPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coffeeOrder_id")
    CoffeeOrder coffeeOrder;

    public Drink() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public String getDrinkDescription() {
        return drinkDescription;
    }

    public void setDrinkDescription(String drinkDescription) {
        this.drinkDescription = drinkDescription;
    }

    public double getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkPrice(double drinkPrice) {
        this.drinkPrice = drinkPrice;
    }

    public CoffeeOrder getCoffeeOrder() {
        return coffeeOrder;
    }

    public void setCoffeeOrder(CoffeeOrder coffeeOrder) {
        this.coffeeOrder = coffeeOrder;
    }

}
