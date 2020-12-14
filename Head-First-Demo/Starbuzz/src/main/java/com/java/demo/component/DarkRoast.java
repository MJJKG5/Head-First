package com.java.demo.component;

import com.java.demo.Beverage;

import java.math.BigDecimal;

public class DarkRoast extends Beverage {
    private BigDecimal price = new BigDecimal("0.99");

    public DarkRoast() {
        description = "DarkRoast";
    }

    public void setPrice(double price) {
        this.price = new BigDecimal(price);
    }

    @Override
    public BigDecimal cost() {
        return price;
    }
}
