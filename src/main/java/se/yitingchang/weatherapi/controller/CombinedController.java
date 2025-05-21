package se.yitingchang.weatherapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.yitingchang.weatherapi.model.PollenData;
import se.yitingchang.weatherapi.service.PollenClient;
import se.yitingchang.weatherapi.service.WeatherService;

import java.util.List;

@Controller
public class CombinedController {

    private final WeatherService weatherService;
    private final PollenClient pollenClient;

    @Autowired
    public CombinedController(WeatherService weatherService, PollenClient pollenClient) {
        this.weatherService = weatherService;
        this.pollenClient = pollenClient;
    }

    @GetMapping("/weather")
    public String showWeather(Model model) {
        model.addAttribute("weatherData", weatherService.getOptimalForecast());
        model.addAttribute("pollenList", pollenClient.fetchPollenData());
        return "weather"; 
    }
}
