package edu.ant.patterns.design.command;

import edu.ant.utils.logger.LoggingService;

public class Main {

    public static void main(String[] args) {

        Executor executor = new Executor();
        ForecastAlert forecastAlert = new ForecastAlert("Severe storm", "NW");

        Command levelUpdate = new UpdateCommand(forecastAlert, "Severe storm with hail");
        Command anotherLevelUpdate = new UpdateCommand(forecastAlert, "Possible tornadoes");
        
        LoggingService.logMessage(forecastAlert.getAlertLevel());

        executor.execute(levelUpdate);
        LoggingService.logMessage(forecastAlert.getAlertLevel());

        executor.execute(anotherLevelUpdate);
        LoggingService.logMessage(forecastAlert.getAlertLevel());

        executor.rollback();
        LoggingService.logMessage(forecastAlert.getAlertLevel());

        executor.rollback();
        LoggingService.logMessage(forecastAlert.getAlertLevel());
    }

}
