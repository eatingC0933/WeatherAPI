package se.yitingchang.weatherapi.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import se.yitingchang.weatherapi.model.Smhipojos.Parameter;
import se.yitingchang.weatherapi.model.Smhipojos.TimeSeries;
import se.yitingchang.weatherapi.model.WeatherData;
import se.yitingchang.weatherapi.model.Smhipojos.SmhiResponse;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;



@Component
public class SmhiClient {
    private final WebClient webClient=WebClient.create();

    public WeatherData fetchForecast() {

        SmhiResponse response = webClient.get()
                .uri("https://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/18.0300/lat/59.3110/data.json")
                .retrieve()
                .bodyToMono(SmhiResponse.class)
                .block();


        if (response == null || response.getTimeSeries() == null) {
            throw new RuntimeException("No forecast data received from SMHI");
        }


        LocalDateTime targetTime = LocalDateTime.now().plusHours(24);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

        TimeSeries closest = response.getTimeSeries().stream()
                .min(Comparator.comparing(ts -> Duration.between(
                        LocalDateTime.parse(ts.getValidTime(), formatter),
                        targetTime).abs())).orElseThrow();


        double temperature = extractParameter(closest.getParameters(), "t");
        double humidity = extractParameter(closest.getParameters(), "r");
        LocalDateTime timestamp = LocalDateTime.parse(closest.getValidTime(), formatter);


        WeatherData weatherData = new WeatherData();
        weatherData.setSource("SMHI");
        weatherData.setTemperature(temperature);
        weatherData.setHumidity(humidity);
        weatherData.setTimestamp(timestamp);

        return weatherData;
    }

    private double extractParameter(List<Parameter> parameters, String name) {
        return parameters.stream()
                .filter(p->p.getName().equals(name))
                .findFirst()
                .map(p->p.getValues().get(0))
                .orElseThrow(()->new RuntimeException("Parameter not found: " + name));


    }
}

