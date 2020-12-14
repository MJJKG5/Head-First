package com.java.demo.component;

import com.java.demo.Beverage;

import java.math.BigDecimal;

public class HouseBlend extends Beverage {
    private BigDecimal price = new BigDecimal("0.89");

    public HouseBlend() {
        description = "HouseBlend";
    }

    public void setPrice(double price) {
        this.price = new BigDecimal(price);
    }

    @Override
    public BigDecimal cost() {
        return price;
    }
}
