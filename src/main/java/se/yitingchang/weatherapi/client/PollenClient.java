package se.yitingchang.weatherapi.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import se.yitingchang.weatherapi.model.PollenData;
import se.yitingchang.weatherapi.model.Pollenpojos.LevelSeries;
import se.yitingchang.weatherapi.model.Pollenpojos.PollenResponse;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class PollenClient {

    private final WebClient webClient;

        public PollenClient(WebClient webClient) {
        this.webClient = webClient;
    }

    private static final String REGION_ID = "2a2a2a2a-2a2a-4a2a-aa2a-2a2a2a303a32";

    private static final Map<String, String> POLLEN_ID_TO_NAME = Map.ofEntries(
            Map.entry("2a2a2a2a-2a2a-4a2a-aa2a-2a313a323233", "Hazel"),
            Map.entry("2a2a2a2a-2a2a-4a2a-aa2a-2a313a323236", "Al"),
            Map.entry("2a2a2a2a-2a2a-4a2a-aa2a-2a313a323330", "Salg and Viden"),
            Map.entry("2a2a2a2a-2a2a-4a2a-aa2a-2a313a323331", "Elm"),
            Map.entry("2a2a2a2a-2a2a-4a2a-aa2a-2a313a323232", "Birch"),
            Map.entry("2a2a2a2a-2a2a-4a2a-aa2a-2a313a323335", "Book"),
            Map.entry("2a2a2a2a-2a2a-4a2a-aa2a-2a313a323337", "OAK"),
            Map.entry("2a2a2a2a-2a2a-4a2a-aa2a-2a313a323433", "Grass"),
            Map.entry("2a2a2a2a-2a2a-4a2a-aa2a-2a313a323530", "Mugwort")
    );

    public List<PollenData> fetchForecast() {
        PollenResponse forecastResponse = webClient.get()
                .uri("https://api.pollenrapporten.se/v1/forecasts?region_id=" + REGION_ID)
                .retrieve()
                .bodyToMono(PollenResponse.class)
                .block();

        if (forecastResponse == null || forecastResponse.getItems() == null) {
            return Collections.emptyList();
        }

        return forecastResponse.getItems().stream()
                .flatMap(item -> item.getLevelSeries().stream())
                .filter(series -> series.getLevel() != null && series.getLevel() > 1)
                .map(series -> new PollenData(
                        series.getTime().substring(0, 10),
                        POLLEN_ID_TO_NAME.getOrDefault(series.getPollenId(), "Unknown"),
                        mapLevelToText(series.getLevel())
                ))
                .collect(Collectors.toList());
    }

    private String mapLevelToText(int level) {
        return switch (level) {
            case 0 -> "None";
            case 1 -> "Very Low";
            case 2 -> "Low";
            case 3 -> "Moderate";
            case 4 -> "Medium";
            case 5 -> "High";
            case 6 -> "Very High";
            case 7 -> "Extremely High";
            default -> "Unknown";
        };
    }
}
