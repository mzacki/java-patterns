package edu.ant.patterns.design.command;

public class ForecastAlert {

    private String alertLevel;
    private String area;

    public ForecastAlert(String alertLevel, String area) {
        this.alertLevel = alertLevel;
        this.area = area;
    }

    public String getAlertLevel() {
        return alertLevel;
    }

    public void setAlertLevel(String alertLevel) {
        this.alertLevel = alertLevel;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
