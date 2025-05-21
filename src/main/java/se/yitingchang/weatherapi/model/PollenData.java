package se.yitingchang.weatherapi.model;

public class PollenData {

    private String id;
    private String name;
    private String level;

    public PollenData(String id, String name, String level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    public PollenData(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
