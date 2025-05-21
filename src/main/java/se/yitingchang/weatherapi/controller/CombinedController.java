package se.yitingchang.weatherapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.yitingchang.weatherapi.model.PollenData;
import se.yitingchang.weatherapi.model.WeatherData;
import se.yitingchang.weatherapi.service.PollenService;
import se.yitingchang.weatherapi.service.WeatherService;

import java.util.List;

@Controller
public class CombinedController {

    private final WeatherService weatherService;
    private final PollenService pollenService;

    @Autowired
    public CombinedController(WeatherService weatherService, PollenService pollenService) {
        this.weatherService = weatherService;
        this.pollenService = pollenService;
    }

    @GetMapping("/weather")
    public String showWeather(Model model) {
        WeatherData smhi = weatherService.getSmhiForecast();
        WeatherData met = weatherService.getMetForecast();
        WeatherData optimal = weatherService.chooseBestWeather(smhi, met);
        List<PollenData> pollenList=pollenService.getTop3PollenData();


        model.addAttribute("weather", optimal);
        model.addAttribute("smhi", smhi);
        model.addAttribute("met", met);
        model.addAttribute("pollenList",pollenList);

        return "weather";
    }

}
