package edu.ant.patterns.io.repository;


public class Forecast implements Entity {
    private long id;
    private String fall;
    private int temperature;
    private int pressure;
    private int windSpeed;

    public Forecast(long id, String fall, int temperature, int pressure, int windSpeed) {
        this.id = id;
        this.fall = fall;
        this.temperature = temperature;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
    }

    public Forecast(String fall, int temperature, int pressure, int windSpeed) {
        this.fall = fall;
        this.temperature = temperature;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
    }

    public Forecast(Forecast forecast) {
        this.id = forecast.id;
        this.fall = forecast.fall;
        this.temperature = forecast.temperature;
        this.windSpeed = forecast.windSpeed;
        this.pressure = forecast.pressure;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public void setFall(String fall) {
        this.fall = fall;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    @Override
    public long getId() {
        return id;
    }

    public String getFall() {
        return fall;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getPressure() {
        return pressure;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "id=" + id +
                ", fall='" + fall + '\'' +
                ", temperature=" + temperature +
                ", pressure=" + pressure +
                ", windSpeed=" + windSpeed +
                '}';
    }

}
