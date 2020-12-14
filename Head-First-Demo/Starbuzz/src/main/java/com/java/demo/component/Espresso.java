package com.java.demo.component;

import com.java.demo.Beverage;

import java.math.BigDecimal;

public class Espresso extends Beverage {
    private BigDecimal price = new BigDecimal("1.99");

    public Espresso() {
        description = "Espresso";
    }

    public void setPrice(double price) {
        this.price = new BigDecimal(price);
    }

    @Override
    public BigDecimal cost() {
        return price;
    }
}
