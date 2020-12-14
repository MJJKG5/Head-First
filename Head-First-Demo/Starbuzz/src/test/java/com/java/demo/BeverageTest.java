package com.java.demo;

import com.java.demo.component.HouseBlend;
import com.java.demo.decorate.Mocha;
import com.java.demo.decorate.Soy;
import com.java.demo.decorate.Whip;
import org.junit.Test;

import java.math.BigDecimal;

public class BeverageTest {
    @Test
    public void houseBlend() {
        Beverage beverage = new HouseBlend();

        Mocha mocha = new Mocha(beverage);
        mocha.setNumber(2);

        Soy soy = new Soy(mocha);

        Whip whip = new Whip(soy);

        System.out.println("共计：" + whip.cost() + "$");
        System.out.println("菜单：" + whip.getDescription());
    }

    @Test
    public void houseBlendAndSoy() {
        Beverage beverage = new HouseBlend();
        beverage.setSize("venti");

        Soy soy = new Soy(beverage);
        soy.setPrice();

        System.out.println("共计：" + soy.cost() + "$");
        System.out.println("菜单：" + soy.getDescription());
    }
}
