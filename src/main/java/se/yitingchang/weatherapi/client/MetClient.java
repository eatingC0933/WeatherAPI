package se.yitingchang.weatherapi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import se.yitingchang.weatherapi.model.WeatherData;
import se.yitingchang.weatherapi.model.pojo.MetResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class MetClient {
    private final WebClient webClient=WebClient.create();

    public WeatherData fetchForecast() {
        MetResponse response = webClient.get()
                .uri("https://api.met.no/weatherapi/locationforecast/2.0/compact?lat=59.3110&lon=18.0300")
                .retrieve()
                .bodyToMono(MetResponse.class)
                .block();

        return extract24hForecast(response);
    }

    private WeatherData extract24hForecast(MetResponse response) {
        String timestampStr = response.getTime();
        LocalDateTime timestamp = LocalDateTime.parse(timestampStr, DateTimeFormatter.ISO_DATE_TIME);

        return new WeatherData("MET",response.getAirTemperature(), response.getRelativeHumidity(),timestamp);
    }
}
