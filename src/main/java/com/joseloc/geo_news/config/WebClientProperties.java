package com.joseloc.geo_news.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties( prefix = "webclient" )
public class WebClientProperties {
    private String baseUrl;
    private int timeout;
    //private Map<String, String> headers;
    //private Map<String, String> cookies;
}
