package se.yitingchang.weatherapi.model.pojo;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "time",
        "air_temperature",
        "relative_humidity",
        "symbol_code"
})
@Generated("jsonschema2pojo")
public class MetResponse {

    @JsonProperty("type")
    private String type;
    @JsonProperty("time")
    private String time;
    @JsonProperty("air_temperature")
    private Double airTemperature;
    @JsonProperty("relative_humidity")
    private Integer relativeHumidity;
    @JsonProperty("symbol_code")
    private String symbolCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("air_temperature")
    public Double getAirTemperature() {
        return airTemperature;
    }

    @JsonProperty("air_temperature")
    public void setAirTemperature(Double airTemperature) {
        this.airTemperature = airTemperature;
    }

    @JsonProperty("relative_humidity")
    public Integer getRelativeHumidity() {
        return relativeHumidity;
    }

    @JsonProperty("relative_humidity")
    public void setRelativeHumidity(Integer relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    @JsonProperty("symbol_code")
    public String getSymbolCode() {
        return symbolCode;
    }

    @JsonProperty("symbol_code")
    public void setSymbolCode(String symbolCode) {
        this.symbolCode = symbolCode;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}