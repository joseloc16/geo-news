package com.joseloc.geo_news.service;

import com.joseloc.geo_news.client.WeatherApiClient;
import com.joseloc.geo_news.dto.WeatherInfoDTO;
import com.joseloc.geo_news.dto.WeatherResponseDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.OptionalInt;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class WeatherService implements IIWeatherService {

    private final WeatherApiClient weatherApiClient;
    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);

    @Override
    public WeatherResponseDTO getWeatherForCity(String latitude, String longitude) {
        WeatherResponseDTO weatherResponseDTO = new WeatherResponseDTO();
        WeatherInfoDTO weatherInfoDTO = weatherApiClient.getWeather(latitude, longitude);
        String currentHour = getCurrentHour();

        OptionalInt optionalIndice = IntStream.range(0, weatherInfoDTO.getHourly().getTime().size())
                .filter(i -> currentHour.equals(weatherInfoDTO.getHourly().getTime().get(i).substring(11, 13)))
                .findFirst();

        optionalIndice.ifPresentOrElse(
                index -> {
                    Double temperature = weatherInfoDTO.getHourly().getTemperature_2m().get(index);
                    weatherResponseDTO.setHour(currentHour);
                    weatherResponseDTO.setTemperature(temperature);
                    logger.info(">>> Current temperature at {}: {}°C", currentHour, temperature);
                },
                () -> logger.warn(">>> No matching hour found in the response.")
        );

        return weatherResponseDTO;
    }

    private String getCurrentHour() {
        DateFormat dateFormat = new SimpleDateFormat("HH");
        Date date = new Date();
        return dateFormat.format(date);
    }
}