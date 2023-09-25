package org.demo.entity;

/**
 * @author Igor Adulyan
 */
public class CoffeeOrder {

    private int id;
    private int drinkId;
    private int quantity;

    private String nameOnOrder;

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
