package com.joseloc.geo_news.client;

import com.joseloc.geo_news.dto.WeatherInfoDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import reactor.util.retry.Retry;

import java.time.Duration;

@Slf4j
@RequiredArgsConstructor
@Component
public class WeatherApiClient implements IIWeatherApiClient {

    private final WebClient weatherWebClient;

    @Override
    public WeatherInfoDTO getWeather(String latitude, String longitude) {
        log.info(">>> Requesting weather data for latitude: {} and longitude: {}", latitude, longitude);

        return weatherWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("latitude", latitude)
                        .queryParam("longitude", longitude)
                        .queryParam("hourly", "temperature_2m")
                        .build())
                .retrieve()
                .bodyToMono(WeatherInfoDTO.class)
                .retryWhen(
                        Retry.backoff(3, Duration.ofSeconds(1))
                                .filter(throwable -> throwable instanceof WebClientRequestException)
                )
                .block();
    }
}
