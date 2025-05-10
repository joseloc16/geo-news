package com.joseloc.geo_news.controller;

import com.joseloc.geo_news.dto.WeatherResponseDTO;
import com.joseloc.geo_news.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LocationInfoController {

    private final WeatherService weatherService;

    @GetMapping("/weather")
    public WeatherResponseDTO getWeather(@RequestParam String lat, @RequestParam String lon) {
        return weatherService.getWeatherForCity(lat, lon);
    }
}
