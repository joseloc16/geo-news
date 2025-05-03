package com.joseloc.geo_news.dto;

import java.util.Map;

public class WeatherInfo {

    private Map<String, Object> current;

    public Map<String, Object> getCurrent( ) {
        return current;
    }

    public void setCurrent( Map<String, Object> current ) {
        this.current = current;
    }

}
