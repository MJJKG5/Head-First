package com.java.demo;

import com.java.demo.observer.property.CurrentConditionsDisplay;
import com.java.demo.observer.property.HeatIndexDisplay;
import org.junit.Test;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class WeatherDataPropertyTest {
    @Test
    public void weatherData() throws InterruptedException {
        WeatherData weatherData = new WeatherData();

        PropertyChangeListener currentConditions = new CurrentConditionsDisplay();
        PropertyChangeListener heatIndex = new HeatIndexDisplay();

        // 创建主题
        PropertyChangeSupport support = new PropertyChangeSupport(weatherData);

        // 订阅主题
        support.addPropertyChangeListener(currentConditions);
        support.addPropertyChangeListener(heatIndex);

        // 模拟气象数据
        Thread thread = new Thread(() -> {
            int i = 0;
            while (i < 10) {
                weatherData.setWeatherData(80, 65, 30.4f);
                // 模拟取消订阅主题
                if (i == 4) {
                    support.removePropertyChangeListener(heatIndex);
                }
                // 通知
                support.firePropertyChange("通知", null, weatherData);
                i++;
            }
        });
        thread.start();
        thread.join();
    }
}
