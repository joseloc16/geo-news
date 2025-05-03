package com.joseloc.geo_news.client;

import com.joseloc.geo_news.dto.WeatherInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@RequiredArgsConstructor
@Component
public class WeatherApiClient {

    private final WebClient weatherWebClient;

    public WeatherInfo getWeather( String latitude, String longitude ) {

        log.info( ">>> Requesting weather data for latitude: {} and longitude: {}", latitude, longitude );

        return weatherWebClient.get( )
                .uri( uriBuilder -> uriBuilder
                        .queryParam( "latitude", latitude )
                        .queryParam( "longitude", longitude )
                        .queryParam( "current", "temperature_2m" )
                        .build( ) )
                .retrieve( )
                .bodyToMono( WeatherInfo.class )
                .block( );
    }
}
