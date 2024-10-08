package com.akyamasvieira.weather_api.service;

import com.akyamasvieira.weather_api.model.Weather;
import com.akyamasvieira.weather_api.model.WeatherRepository;
import com.akyamasvieira.weather_api.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;
    private final WeatherClient weatherClient;

    // Injeção da chave da API
    @Value("${weather.api.key}")
    private String apiKey;

    @Autowired
    public WeatherService(WeatherRepository weatherRepository, WeatherClient weatherClient) {
        this.weatherRepository = weatherRepository;
        this.weatherClient = weatherClient;
    }

    // Método para salvar as informações do clima
    public Weather saveWeather(Weather weather) {
        return weatherRepository.save(weather);
    }

    // Método para recuperar todas as informações do clima
    public List<Weather> getAllWeatherData() {
        return weatherRepository.findAll();
    }

    // Método para encontrar um clima específico pelo ID
    public Weather getWeatherById(Long id) {
        return weatherRepository.findById(id).orElse(null);
    }

    // Método para obter o clima pela cidade usando o cliente Feign
    public WeatherResponse getWeatherByCity(String city) {
        return weatherClient.getWeatherByCity(city, apiKey); // Passando a chave da API
    }
}