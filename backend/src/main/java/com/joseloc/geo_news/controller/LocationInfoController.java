package com.joseloc.geo_news.controller;

import com.joseloc.geo_news.dto.WeatherResponseDTO;
import com.joseloc.geo_news.dto.response.ApiResponse;
import com.joseloc.geo_news.service.IIWeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LocationInfoController {

    private final IIWeatherService weatherService;

    @GetMapping("/weather")
    public ResponseEntity<ApiResponse<WeatherResponseDTO>> getWeather(@RequestParam String lat, @RequestParam String lon) {
        WeatherResponseDTO weatherResponse = weatherService.getWeatherForCity(lat, lon);
        return ResponseEntity.ok(ApiResponse.success("Weather data retrieved successfully", weatherResponse));
    }
}
