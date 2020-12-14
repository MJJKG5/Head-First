package com.java.demo.decorate;

import com.java.demo.Beverage;
import com.java.demo.CondimentDecorator;

import java.math.BigDecimal;

public class Soy extends CondimentDecorator {
    private int number = 1;
    private BigDecimal price = new BigDecimal("0.15");
    private final Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPrice() {
        switch (beverage.getSize()) {
            case "tall":
                price = new BigDecimal("0.10");
                break;
            case "grande":
                price = new BigDecimal("0.15");
                break;
            case "venti":
                price = new BigDecimal("0.20");
                break;
        }
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy " + number + " 份";
    }

    @Override
    public BigDecimal cost() {
        BigDecimal total = price.multiply(new BigDecimal(number));
        return total.add(beverage.cost());
    }
}
