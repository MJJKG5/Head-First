package com.java.demo;

import java.math.BigDecimal;

public abstract class Beverage {
    private String size;
    protected String description = "Unknown Beverage";

    public abstract BigDecimal cost();

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }
}
