package com.akyamasvieira.weather_api.controller;

import com.akyamasvieira.weather_api.model.Weather;
import com.akyamasvieira.weather_api.model.WeatherResponse;
import com.akyamasvieira.weather_api.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List; // Importação do List

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    public ResponseEntity<WeatherResponse> getWeatherByCity(@PathVariable String city) {
        WeatherResponse weather = weatherService.getWeatherByCity(city);
        return ResponseEntity.ok(weather);
    }
}