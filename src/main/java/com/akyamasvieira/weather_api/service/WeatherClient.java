package com.akyamasvieira.weather_api.service;

import com.akyamasvieira.weather_api.model.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weather-client", url = "https://api.openweathermap.org/data/2.5")
public interface WeatherClient {

    @GetMapping("/weather")
    WeatherResponse getWeatherByCity(
            @RequestParam("q") String city,
            @RequestParam("appid") String apiKey
    );
}