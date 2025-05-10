package com.joseloc.geo_news.service;

import com.joseloc.geo_news.dto.WeatherInfoDTO;

public interface IIWeatherService {
    WeatherInfoDTO getWeatherForCity(String latitude, String longitude);
}
