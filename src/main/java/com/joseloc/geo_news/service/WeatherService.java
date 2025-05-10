package com.joseloc.geo_news.service;

import com.joseloc.geo_news.client.WeatherApiClient;
import com.joseloc.geo_news.dto.WeatherInfoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherService implements IIWeatherService {

    private final WeatherApiClient weatherApiClient;

    @Override
    public WeatherInfoDTO getWeatherForCity(String latitude, String longitude) {
        return weatherApiClient.getWeather(latitude, longitude);
    }
}