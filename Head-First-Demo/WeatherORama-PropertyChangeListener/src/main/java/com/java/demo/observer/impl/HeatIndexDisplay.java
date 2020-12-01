package com.java.demo.observer.impl;

import com.java.demo.WeatherData;
import com.java.demo.observer.DisplayElement;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HeatIndexDisplay implements PropertyChangeListener, DisplayElement {
    private float heatIndex;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        WeatherData weatherData = (WeatherData) evt.getNewValue();
        float temperature = weatherData.getTemperature();
        float humidity = weatherData.getHumidity();

        heatIndex = computeHeatIndex(temperature, humidity);
    }

    @Override
    public void display() {
        System.out.println("酷热指数：" + this.heatIndex);
    }

    /**
     * 计算酷热指数
     *
     * @param t  温度
     * @param rh 湿度
     * @return
     */
    private float computeHeatIndex(float t, float rh) {
        return (float) ((16.923 + (0.185212 * t) + (5.37941 * rh) - (0.100254 * t * rh) +
                (0.00941695 * (t * t)) + (0.00728898 * (rh * rh)) +
                (0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh * rh)) +
                (0.0000102102 * (t * t * rh * rh)) - (0.000038646 * (t * t * t)) + (0.0000291583 *
                (rh * rh * rh)) + (0.00000142721 * (t * t * t * rh)) +
                (0.000000197483 * (t * rh * rh * rh)) - (0.0000000218429 * (t * t * t * rh * rh)) +
                0.000000000843296 * (t * t * rh * rh * rh)) -
                (0.0000000000481975 * (t * t * t * rh * rh * rh)));
    }
}
