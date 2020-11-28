package com.java.demo;

import com.java.demo.behavior.FlyBehavior;
import com.java.demo.behavior.QuackBehavior;
import com.java.demo.behavior.impl.FlyNoWay;
import com.java.demo.behavior.impl.FlyWithWings;
import com.java.demo.behavior.impl.Quack;
import com.java.demo.behavior.impl.QuackSqueak;
import com.java.demo.duck.AbsDuck;
import org.junit.Test;

public class DuckTest {
    @Test
    public void mallardDuck() {
        QuackBehavior quack = new Quack();
        FlyBehavior fly = new FlyWithWings();

        AbsDuck duck = new MallardDuck();
        duck.setQuack(quack);
        duck.setFly(fly);

        duck.display();
        duck.quack();
        duck.fly();
    }

    @Test
    public void redheadDuck() {
        QuackBehavior quack = new QuackSqueak();
        FlyBehavior fly = new FlyWithWings();

        AbsDuck duck = new RedheadDuck();
        duck.setQuack(quack);
        duck.setFly(fly);

        duck.display();
        duck.quack();
        duck.fly();
    }

    @Test
    public void rubberDuck() {
        QuackBehavior quack = new QuackSqueak();
        FlyBehavior fly = new FlyNoWay();

        AbsDuck duck = new RubberDuck();
        duck.setQuack(quack);
        duck.setFly(fly);

        duck.display();
        duck.quack();
        duck.fly();
    }
}
