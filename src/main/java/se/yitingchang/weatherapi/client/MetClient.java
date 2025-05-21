package se.yitingchang.weatherapi.client;


import org.springframework.stereotype.Component;

import org.springframework.web.reactive.function.client.WebClient;
import se.yitingchang.weatherapi.model.Metpojos.MetResponse;
import se.yitingchang.weatherapi.model.Metpojos.Timeseries;
import se.yitingchang.weatherapi.model.WeatherData;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

@Component
public class MetClient {
    private final WebClient webClient=WebClient.create();

    public WeatherData fetchForecast() {
        MetResponse response = webClient.get()
                .uri("https://api.met.no/weatherapi/locationforecast/2.0/compact?lat=59.3110&lon=18.0300")
                .retrieve()
                .bodyToMono(MetResponse.class)
                .block();


        if (response == null || response.getProperties() == null || response.getProperties().getTimeseries() == null) {
            throw new RuntimeException("No forecast data received from MET Norway");
        }

        LocalDateTime targetTime = LocalDateTime.now().plusHours(24);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

        Timeseries closest = response.getProperties().getTimeseries().stream()
                .min(Comparator.comparing(ts -> Duration.between(
                        LocalDateTime.parse(ts.getTime(), formatter),
                        targetTime).abs())).orElseThrow();

        double temperature = closest.getData().getInstant().getDetails().getAirTemperature();
        double humidity=closest.getData().getInstant().getDetails().getRelativeHumidity();
        LocalDateTime timestamp = LocalDateTime.parse(closest.getTime(), formatter);

        WeatherData weatherData = new WeatherData();
        weatherData.setSource("MET");
        weatherData.setTemperature(temperature);
        weatherData.setHumidity(humidity);
        weatherData.setTimestamp(timestamp);

        return weatherData;


    }
}

