package com.joseloc.geo_news.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Configuration
@EnableConfigurationProperties( WebClientProperties.class )
public class WebClientConfig {

    @Bean
    public WebClient weatherWebClient( WebClientProperties props ) {
        HttpClient httpClient = HttpClient.create( )
                .responseTimeout( Duration.ofMillis( props.getTimeout( ) ) );
        return WebClient.builder( )
                .baseUrl( props.getBaseUrl( ) )
                .clientConnector( new ReactorClientHttpConnector( httpClient ) )
                //.defaultHeaders(headers -> props.getHeaders().forEach(headers::add))
                //.defaultCookies(cookies -> props.getCookies().forEach(cookies::add))
                .build( );
    }
}
