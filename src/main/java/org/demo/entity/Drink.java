package org.demo.entity;

import java.util.Objects;

/**
 * @author Igor Adulyan
 */
public class Drink {

    private int id;
    private String name;

    private String description;
    private double price;
    public Drink() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drink)) return false;
        Drink drink = (Drink) o;
        return Double.compare(drink.getPrice(), getPrice()) == 0 && Objects.equals(getName(), drink.getName()) && Objects.equals(getDescription(), drink.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getPrice());
    }
}
