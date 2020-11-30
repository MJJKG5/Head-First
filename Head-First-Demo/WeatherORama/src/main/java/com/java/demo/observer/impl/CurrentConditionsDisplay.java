package com.java.demo.observer.impl;

import com.java.demo.observer.DisplayElement;
import com.java.demo.observer.Observer;
import com.java.demo.subject.Subject;
import com.java.demo.WeatherData;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private final Subject subject;
    private float temperature;
    private float humidity;
    private float pressure;

    public CurrentConditionsDisplay(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void update() {
        if (subject instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) subject;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            this.pressure = weatherData.getPressure();

            display();
        }
    }

    @Override
    public void display() {
        System.out.println("目前状况->温度：" + temperature + "，湿度：" + humidity + "，气压：" + pressure);
    }
}
