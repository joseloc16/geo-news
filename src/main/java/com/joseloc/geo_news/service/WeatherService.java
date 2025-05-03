package com.joseloc.geo_news.service;

import com.joseloc.geo_news.client.WeatherApiClient;
import com.joseloc.geo_news.dto.WeatherInfo;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private final WeatherApiClient weatherApiClient;

    public WeatherService( WeatherApiClient weatherApiClient ) {
        this.weatherApiClient = weatherApiClient;
    }

    public WeatherInfo getWeatherForCity( String latitude, String longitude ) {
        return weatherApiClient.getWeather( latitude, longitude );
    }
}