package com.java.demo.behavior.impl;

import com.java.demo.behavior.QuackBehavior;

public class QuackSqueak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("吱吱叫");
    }
}
