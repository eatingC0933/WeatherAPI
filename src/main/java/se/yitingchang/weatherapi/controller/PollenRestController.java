package se.yitingchang.weatherapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.yitingchang.weatherapi.client.PollenClient;
import se.yitingchang.weatherapi.model.PollenData;
import se.yitingchang.weatherapi.model.Pollenpojos.PollenResponse;
import se.yitingchang.weatherapi.service.PollenService;

import java.util.List;

@RestController
@RequestMapping("/api/pollen")
public class PollenAPIController {

    private final PollenService pollenService;
    private final PollenClient pollenClient;

    @Autowired
    public PollenAPIController(PollenService pollenService, PollenClient pollenClient) {
        this.pollenService = pollenService;
        this.pollenClient = pollenClient;
    }

    @GetMapping
    public List<PollenData> getAllPollenData() {
        PollenResponse response = pollenService.fetchPollenData();
        return pollenClient.toPollenDataList(response);
    }
}
