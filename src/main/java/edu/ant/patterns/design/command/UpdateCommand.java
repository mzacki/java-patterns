package edu.ant.patterns.design.command;


public class UpdateCommand implements Command {

    private final ForecastAlert forecastAlert;
    private final String updatedLevel;
    private String previousLevel;


    public UpdateCommand(ForecastAlert forecastAlert, String updatedLevel) {
        this.forecastAlert = forecastAlert;
        this.updatedLevel = updatedLevel;
    }

    @Override
    public void execute() {
        previousLevel = forecastAlert.getAlertLevel();
        forecastAlert.setAlertLevel(updatedLevel);
    }

    @Override
    public void rollback() {
        forecastAlert.setAlertLevel(previousLevel);
    }

}
