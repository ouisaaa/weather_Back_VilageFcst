package org.example.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class WeatherTMXN {
    private String category;
    private String baseDate;
    private String baseTime;
    private String value;
    private int nx;
    private int ny;

}
