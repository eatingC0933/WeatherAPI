package se.yitingchang.weatherapi.model;


import java.time.LocalDateTime;

public class WeatherData {
    private String source;
    private double temperature;
    private double humidity;
    private LocalDateTime timestamp;

    public WeatherData(String source, double temperature, double humidity, LocalDateTime timestamp) {
        this.source = source;
        this.temperature = temperature;
        this.humidity = humidity;
        this.timestamp = timestamp;
    }

    public WeatherData() {
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "source='" + source + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
