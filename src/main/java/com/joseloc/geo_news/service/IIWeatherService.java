package com.joseloc.geo_news.service;

import com.joseloc.geo_news.dto.WeatherResponseDTO;

public interface IIWeatherService {
    WeatherResponseDTO getWeatherForCity(String latitude, String longitude);
}
