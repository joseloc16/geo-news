package com.joseloc.geo_news.client;

import com.joseloc.geo_news.dto.WeatherInfoDTO;

public interface IIWeatherApiClient {
    WeatherInfoDTO getWeather(String latitude, String longitude);
}
