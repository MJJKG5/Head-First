package com.java.demo;

import com.java.demo.observer.Observer;
import com.java.demo.observer.impl.CurrentConditionsDisplay;
import com.java.demo.observer.impl.HeatIndexDisplay;
import org.junit.Test;

public class WeatherDataTest {
    @Test
    public void weatherData() throws InterruptedException {
        // 主题
        WeatherData weatherData = new WeatherData();

        // 观察者
        Observer currentConditions = new CurrentConditionsDisplay(weatherData);
        Observer heatIndex = new HeatIndexDisplay(weatherData);

        // 订阅主题
        weatherData.registerObserver(currentConditions);
        weatherData.registerObserver(heatIndex);

        // 模拟气象数据
        Thread thread = new Thread(() -> {
            int i = 0;
            while (i < 10) {
                weatherData.setWeatherData(80, 65, 30.4f);
                // 模拟取消订阅主题
                if (i == 4) {
                    weatherData.removeObserver(heatIndex);
                }
                i++;
            }
        });
        thread.start();
        thread.join();
    }
}
