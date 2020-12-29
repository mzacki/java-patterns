package edu.ant.patterns.io.repository;


public class Alert implements Entity {

    private long id;
    private String level;
    private String area;
    private String type;
    private int probability;

    public Alert(long id, String level, String area, String type, int probability) {
        this.id = id;
        this.level = level;
        this.area = area;
        this.type = type;
        this.probability = probability;
    }

    public Alert(String level, String area, String type, int probability) {
        this.level = level;
        this.area = area;
        this.type = type;
        this.probability = probability;
    }

    public Alert(Alert alert) {
        this.id = alert.id;
        this.level = alert.level;
        this.area = alert.area;
        this.type = alert.type;
        this.probability = alert.probability;
    }

    @Override
    public long getId() {
        return id;
    }

    public String getLevel() {
        return level;
    }

    public String getArea() {
        return area;
    }

    public String getType() {
        return type;
    }

    public int getProbability() {
        return probability;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

    @Override
    public String toString() {
        return "WeatherAlert{" +
                "id=" + id +
                ", level='" + level + '\'' +
                ", area='" + area + '\'' +
                ", type='" + type + '\'' +
                ", probability=" + probability +
                '}';
    }
}
