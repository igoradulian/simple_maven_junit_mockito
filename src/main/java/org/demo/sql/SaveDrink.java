package org.demo.sql;

/**
 * @author Igor Adulyan
 */
public enum SaveDrink {

    ADD_DRINK("INSERT INTO Drink(name,description, price ) VALUES (?,?,?)");

    private String sql;

    SaveDrink(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }
}
