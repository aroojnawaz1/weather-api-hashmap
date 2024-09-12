package com.example.weatherapi.controller;

import com.example.weatherapi.dtos.LocationRequest;
import com.example.weatherapi.service.WeatherApiServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherApiController {

    private final WeatherApiServiceImpl weatherService;

    public WeatherApiController(WeatherApiServiceImpl weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping("/getWeather")
    public ResponseEntity<String> getWeather(@RequestBody LocationRequest locationRequest) {
        String weatherData = weatherService.getWeatherData(locationRequest.getLatitude(), locationRequest.getLongitude());
        return ResponseEntity.ok(weatherData);
    }
}

