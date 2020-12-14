package com.java.demo.component;

import com.java.demo.Beverage;

import java.math.BigDecimal;

public class Decaf extends Beverage {
    private BigDecimal price = new BigDecimal("1.05");

    public Decaf() {
        description = "Decaf";
    }

    public void setPrice(double price) {
        this.price = new BigDecimal(price);
    }

    @Override
    public BigDecimal cost() {
        return price;
    }
}
