package com.joseloc.geo_news.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient weatherWebClient( WebClient.Builder builder ) {
        return WebClient.builder( )
                .baseUrl( "https://api.open-meteo.com/v1/forecast" )
                .defaultCookie( "cookieKey", "cookieValue" )
                .defaultHeader( HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE )
                .defaultUriVariables( Collections.singletonMap( "url", "http://localhost:8080" ) )
                .build( );
    }
}
