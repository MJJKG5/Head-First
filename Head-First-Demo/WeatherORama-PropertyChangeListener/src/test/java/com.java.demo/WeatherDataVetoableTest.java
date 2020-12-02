package com.java.demo;

import com.java.demo.observer.vetoable.CurrentConditionsDisplay;
import com.java.demo.observer.vetoable.HeatIndexDisplay;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;

public class WeatherDataVetoableTest {
    @Test
    public void weatherData() throws InterruptedException {
        WeatherData weatherData = new WeatherData();

        VetoableChangeListener currentConditions = new CurrentConditionsDisplay();
        VetoableChangeListener heatIndex = new HeatIndexDisplay();

        // 创建主题
        VetoableChangeSupport support = new VetoableChangeSupport(weatherData);

        // 订阅主题
        support.addVetoableChangeListener(currentConditions);
        support.addVetoableChangeListener(heatIndex);

        // 模拟气象数据
        Thread thread = new Thread(() -> {
            int i = 0;
            while (i < 10) {
                weatherData.setWeatherData(80, 65, 30.4f);
                // 模拟取消订阅主题
                if (i == 4) {
                    support.removeVetoableChangeListener(heatIndex);
                }
                // 通知
                try {
                    support.fireVetoableChange("通知", null, weatherData);
                } catch (PropertyVetoException e) {
                    e.printStackTrace();
                }
                i++;
            }
        });
        thread.start();
        thread.join();
    }
}
