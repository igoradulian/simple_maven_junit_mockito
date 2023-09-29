package org.demo.entity;

import jakarta.persistence.*;

/**
 * @author Igor Adulyan
 */

@Entity
@NamedQueries({
        @NamedQuery(name = "findCustomerByName", query = "from Customer where name=:name")
})
public class Customer {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String phone;

    private String email;

    @OneToOne(mappedBy = "drink")
    private Drink drink;

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }
}
