package com.java.demo.duck;

import com.java.demo.behavior.FlyBehavior;
import com.java.demo.behavior.QuackBehavior;

public abstract class AbsDuck {
    private QuackBehavior quack;
    private FlyBehavior fly;

    public abstract void display();

    public void quack() {
        quack.quack();
    }

    public void fly() {
        fly.fly();
    }

    public QuackBehavior getQuack() {
        return quack;
    }

    public void setQuack(QuackBehavior quack) {
        this.quack = quack;
    }

    public FlyBehavior getFly() {
        return fly;
    }

    public void setFly(FlyBehavior fly) {
        this.fly = fly;
    }
}
