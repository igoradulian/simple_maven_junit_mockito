package org.demo.sql;

/**
 * @author Igor Adulyan
 */
public enum FindDrink {
    BY_NAME("select * from drink where name=?"),
    BY_ID("select * from drink where id=?"),

    ALL("select * from drink");
    private String sql;

    FindDrink(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }
}
