package se.yitingchang.weatherapi.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.yitingchang.weatherapi.model.WeatherData;

@Service
public class WeatherService {
    @Autowired
    private final SmhiClient smhiClient;
    @Autowired
    private final MetClient metClient;

    public WeatherService(SmhiClient smhiClient, MetClient metClient) {
        this.smhiClient = smhiClient;
        this.metClient = metClient;
    }


    public WeatherData getOptimalForecast() {
        WeatherData data1 = smhiClient.fetchForecast();
        WeatherData data2 = metClient.fetchForecast();

        return chooseBestWeather(data1, data2);
    }

    private WeatherData chooseBestWeather(WeatherData w1, WeatherData w2) {
        if (w1 == null) return w2;
        if (w2 == null) return w1;
        return (w1.getTemperature() > w2.getTemperature() && w1.getHumidity() < w2.getHumidity()) ? w1 : w2;
    }
}

