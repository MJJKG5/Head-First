package com.java.demo.behavior.impl;

import com.java.demo.behavior.QuackBehavior;

public class QuackMute implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("不会叫");
    }
}
