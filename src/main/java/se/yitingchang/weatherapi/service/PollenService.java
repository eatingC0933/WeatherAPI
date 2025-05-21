package se.yitingchang.weatherapi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.yitingchang.weatherapi.client.PollenClient;
import se.yitingchang.weatherapi.model.PollenData;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PollenService {

    private final PollenClient pollenClient;

    @Autowired
    public PollenService(PollenClient pollenClient){
        this.pollenClient = pollenClient;
    }


    public List<PollenData> getPollenDataFromResponse() {
        return pollenClient.fetchForecast();


    }
    public List<PollenData> getTop3PollenData() {
        return pollenClient.fetchForecast().stream()
                .collect(Collectors.toMap(
                        PollenData::getLevel,
                        data -> data,
                        (existing, replacement) -> mapLevelToInt(existing) >= mapLevelToInt(replacement) ? existing : replacement
                ))
                .values().stream()
                .sorted(Comparator.comparingInt(this::mapLevelToInt).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }


    private int mapLevelToInt(PollenData data) {
        return switch (data.getLevel()) {
            case "Extremely High" -> 7;
            case "Very High" -> 6;
            case "High" -> 5;
            case "Medium" -> 4;
            case "Moderate" -> 3;
            case "Low" -> 2;
            case "Very Low" -> 1;
            case "None" -> 0;
            default -> 0;
        };
    }

}



