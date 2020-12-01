package com.java.demo.observer.impl;

import com.java.demo.WeatherData;
import com.java.demo.observer.DisplayElement;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CurrentConditionsDisplay implements PropertyChangeListener, DisplayElement {
    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        WeatherData weatherData = (WeatherData) evt.getNewValue();
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        this.pressure = weatherData.getPressure();
    }

    @Override
    public void display() {
        System.out.println("目前状况->温度：" + this.temperature + "，湿度：" + this.humidity + "，气压：" + this.pressure);
    }
}
