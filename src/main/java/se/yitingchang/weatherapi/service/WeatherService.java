package se.yitingchang.weatherapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.yitingchang.weatherapi.client.MetClient;
import se.yitingchang.weatherapi.client.SmhiClient;
import se.yitingchang.weatherapi.model.WeatherData;


@Service
public class WeatherService {
    private final SmhiClient smhiClient;
    private final MetClient metClient;

    @Autowired
    public WeatherService(SmhiClient smhiClient, MetClient metClient) {
        this.smhiClient = smhiClient;
        this.metClient = metClient;
    }

    public WeatherData getSmhiForecast() {
        return smhiClient.fetchForecast();
    }

    public WeatherData getMetForecast() {
        return metClient.fetchForecast();
    }

    public WeatherData getOptimalForecast() {
        WeatherData smhi = getSmhiForecast();
        WeatherData met = getMetForecast();
        return chooseBestWeather(smhi, met);
    }

    //Choose the best weather by "Score = temperature - (humidity / 2)"
    public WeatherData chooseBestWeather(WeatherData w1, WeatherData w2) {
        if (w1 == null) return w2;
        if (w2 == null) return w1;

        double score1 = w1.getTemperature() - (w1.getHumidity() / 2.0);
        double score2 = w2.getTemperature() - (w2.getHumidity() / 2.0);

        return score1 >= score2 ? w1 : w2;
    }

}



