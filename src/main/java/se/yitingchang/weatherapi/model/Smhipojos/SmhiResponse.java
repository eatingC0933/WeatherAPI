package se.yitingchang.weatherapi.model.pojo;

import java.util.LinkedHashMap;
import java.util.List;
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
        "validTime",
        "name",
        "levelType",
        "level",
        "unit",
        "values"
})
@Generated("jsonschema2pojo")
public class SmhiResponse {

    @JsonProperty("type")
    private String type;
    @JsonProperty("validTime")
    private String validTime;
    @JsonProperty("name")
    private String name;
    @JsonProperty("levelType")
    private String levelType;
    @JsonProperty("level")
    private Integer level;
    @JsonProperty("unit")
    private String unit;
    @JsonProperty("values")
    private List<Double> values;
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

    @JsonProperty("validTime")
    public String getValidTime() {
        return validTime;
    }

    @JsonProperty("validTime")
    public void setValidTime(String validTime) {
        this.validTime = validTime;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("levelType")
    public String getLevelType() {
        return levelType;
    }

    @JsonProperty("levelType")
    public void setLevelType(String levelType) {
        this.levelType = levelType;
    }

    @JsonProperty("level")
    public Integer getLevel() {
        return level;
    }

    @JsonProperty("level")
    public void setLevel(Integer level) {
        this.level = level;
    }

    @JsonProperty("unit")
    public String getUnit() {
        return unit;
    }

    @JsonProperty("unit")
    public void setUnit(String unit) {
        this.unit = unit;
    }

    @JsonProperty("values")
    public List<Double> getValues() {
        return values;
    }

    @JsonProperty("values")
    public void setValues(List<Double> values) {
        this.values = values;
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