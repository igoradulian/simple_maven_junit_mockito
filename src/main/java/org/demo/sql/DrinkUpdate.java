package org.demo.sql;

/**
 * @author Igor Adulyan
 */
public enum DrinkUpdate {
    DRINK_UPDATE("update drink set name= ?, description= ?, price= ? where id= ?");
    private String sql;

    DrinkUpdate(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }
}
