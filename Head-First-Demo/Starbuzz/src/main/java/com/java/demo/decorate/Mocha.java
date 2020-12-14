package com.java.demo.decorate;

import com.java.demo.Beverage;
import com.java.demo.CondimentDecorator;

import java.math.BigDecimal;

public class Mocha extends CondimentDecorator {
    private int number = 1;
    private BigDecimal price;
    private final Beverage beverage;

    public Mocha(Beverage beverage) {
        this.price = new BigDecimal("0.20");
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
        return beverage.getDescription() + ", Mocha " + number + " 份";
    }

    @Override
    public BigDecimal cost() {
        BigDecimal total = price.multiply(new BigDecimal(number));
        return total.add(beverage.cost());
    }
}
