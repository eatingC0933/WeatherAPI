package se.yitingchang.weatherapi.model.Pollenpojos;

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
        "id",
        "regionId",
        "startDate",
        "endDate",
        "text",
        "isEndOfSeason",
        "images",
        "levelSeries"
})
@Generated("jsonschema2pojo")
public class Item {

    @JsonProperty("id")
    private String id;
    @JsonProperty("regionId")
    private String regionId;
    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("endDate")
    private String endDate;
    @JsonProperty("text")
    private String text;
    @JsonProperty("isEndOfSeason")
    private Object isEndOfSeason;
    @JsonProperty("images")
    private List<Object> images;
    @JsonProperty("levelSeries")
    private List<LevelSeries> levelSeries;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("regionId")
    public String getRegionId() {
        return regionId;
    }

    @JsonProperty("regionId")
    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    @JsonProperty("startDate")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("startDate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("endDate")
    public String getEndDate() {
        return endDate;
    }

    @JsonProperty("endDate")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("isEndOfSeason")
    public Object getIsEndOfSeason() {
        return isEndOfSeason;
    }

    @JsonProperty("isEndOfSeason")
    public void setIsEndOfSeason(Object isEndOfSeason) {
        this.isEndOfSeason = isEndOfSeason;
    }

    @JsonProperty("images")
    public List<Object> getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(List<Object> images) {
        this.images = images;
    }

    @JsonProperty("levelSeries")
    public List<LevelSeries> getLevelSeries() {
        return levelSeries;
    }

    @JsonProperty("levelSeries")
    public void setLevelSeries(List<LevelSeries> levelSeries) {
        this.levelSeries = levelSeries;
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
