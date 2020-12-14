package com.java.demo.decorate;

import com.java.demo.Beverage;
import com.java.demo.CondimentDecorator;

import java.math.BigDecimal;

public class Milk extends CondimentDecorator {
    private int number = 1;
    private BigDecimal price;
    private final Beverage beverage;

    public Milk(Beverage beverage) {
        this.price = new BigDecimal("0.10");
        this.beverage = beverage;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPrice(double price) {
        this.price = new BigDecimal(price);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk " + number + " 份";
    }

    @Override
    public BigDecimal cost() {
        BigDecimal total = price.multiply(new BigDecimal(number));
        return total.add(beverage.cost());
    }
}
