package com.java.demo.behavior.impl;

import com.java.demo.behavior.FlyBehavior;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("用翅膀飞");
    }
}
