package org.demo.entity;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoffeeOrder)) return false;
        CoffeeOrder that = (CoffeeOrder) o;
        return getDrinkId() == that.getDrinkId() && getQuantity() == that.getQuantity() && Objects.equals(getNameOnOrder(), that.getNameOnOrder());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDrinkId(), getQuantity(), getNameOnOrder());
    }

    @Override
    public String toString() {
        return "CoffeeOrder{" +
                "id=" + id +
                ", drinkId=" + drinkId +
                ", quantity=" + quantity +
                ", nameOnOrder='" + nameOnOrder + '\'' +
                '}';
    }
}
