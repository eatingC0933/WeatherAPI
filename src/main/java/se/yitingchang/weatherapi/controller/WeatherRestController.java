package se.yitingchang.weatherapi.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.yitingchang.weatherapi.model.WeatherData;
import se.yitingchang.weatherapi.service.WeatherService;

@RestController
@RequestMapping("/api/weather")
public class WeatherRestController {

    private final WeatherService weatherService;

    public WeatherRestController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public WeatherData getOptimalWeather() {
        return weatherService.getOptimalForecast();
    }
}
