package se.yitingchang.weatherapi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import se.yitingchang.weatherapi.model.WeatherData;
import se.yitingchang.weatherapi.client.SmhiResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class SmhiClient {
    private final WebClient webClient=WebClient.create();

    public WeatherData fetchForecast() {
        SmhiResponse response = webClient.get()
                .uri("https://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/18.0300/lat/59.3110/data.json")
                .retrieve()
                .bodyToMono(SmhiResponse.class)
                .block();

        return extract24hForecast(response);
    }

    private WeatherData extract24hForecast(SmhiResponse response) {
        String timestampStr = response.getTimestamp();
        LocalDateTime timestamp = LocalDateTime.parse(timestampStr, DateTimeFormatter.ISO_DATE_TIME);

        return new WeatherData("SMHI",response.getTemp(),response.getHumidity(),timestamp);
    }
}
