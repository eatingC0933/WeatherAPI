package se.yitingchang.weatherapi.service;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import se.yitingchang.weatherapi.model.PollenData;
import se.yitingchang.weatherapi.model.PollenLevel;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PollenClient {

    private final WebClient webClient=WebClient.create();


    public List<PollenData> fetchPollenData() {
        PollenData[] rawData = webClient.get()
                .uri("https://api.pollenrapporten.se/v1/forecasts?region_id=2a2a2a2a-2a2a-4a2a-aa2a-2a2a2a303a32&current=true")
                .retrieve()
                .bodyToMono(PollenData[].class)
                .block();

        if (rawData == null) return List.of();

        return List.of(rawData).stream()
                .map(data -> {
                    Integer threshold = data.getThreshold() != null ? data.getThreshold() : 0;
                    PollenLevel level = PollenLevel.fromThreshold(threshold);
                    data.setAdditionalProperty("level", level.name());
                    return data;
                })
                .collect(Collectors.toList());
    }
}
