package com.joseloc.geo_news.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WeatherInfoDTO {
    private double latitude;
    private double longitude;
    private double generationTimeMs;
    private int utcOffsetSeconds;
    private String timezone;
    private String timezoneAbbreviation;
    private double elevation;

    private HourlyUnits hourly_units;
    private Hourly hourly;

    @Getter
    @Setter
    private static class HourlyUnits {
        private String time;
        private String temperature_2m;
    }

    @Getter
    @Setter
    private static class Hourly {
        private List<String> time;
        private List<String> temperature_2m;
    }
}
