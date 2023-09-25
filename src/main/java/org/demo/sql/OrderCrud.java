package org.demo.sql;

/**
 * @author Igor Adulyan
 */
public enum OrderCrud {

    ADD_ORDER("insert into coffee_order(drink_id,quantity, name_on_order) values(?,?,?)"),

    UPDATE_ORDER("update  coffee_order set quantity = ? where id = ?"),

    FIND_ORDER_BY_NAME("select * from coffee_order where name_on_order=?");

    private String sql;

    OrderCrud(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }
}
