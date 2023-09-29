package org.demo.entity;


import jakarta.persistence.*;

import java.util.List;

/**
 * @author Igor Adulyan
 */

@NamedQueries({
        @NamedQuery(name = "findCoffeeOrderById", query = "from CoffeeOrder where id=:id")
})
@Entity
public class CoffeeOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int drinkId;
    private int quantity;

    private String nameOnOrder;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "coffeeOrder",
            orphanRemoval = true)
    private List<Drink> drink;

    public CoffeeOrder() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(int drinkId) {
        this.drinkId = drinkId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNameOnOrder() {
        return nameOnOrder;
    }

    public void setNameOnOrder(String nameOnOrder) {
        this.nameOnOrder = nameOnOrder;
    }
}

