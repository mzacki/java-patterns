package edu.ant.patterns.io.repository;

import edu.ant.patterns.utils.logger.LoggingService;

public class Main {

    public static void main(String[] args) {
        ForecastRepository forecastRepository = new ForecastRepository();
        // GET ALL ENTITIES
        LoggingService.logMessage(forecastRepository.getEntities());
        AlertRepository alertRepository = new AlertRepository();
        LoggingService.logMessage(alertRepository.getEntities());
        // GET BY ID
        LoggingService.logMessage(alertRepository.getById(1L));
        //DELETE BY ID
        alertRepository.deleteById(3L);
        LoggingService.logMessage(alertRepository.getEntities());
        // ADD ENTITY
        Alert alert = new Alert("purple", "S", "foehn wind", 100);
        alertRepository.insert(alert);
        LoggingService.logMessage(alertRepository.getEntities());
        // UPDATE ENTITY
        alert.setLevel("black");
        alertRepository.update(alert);
        LoggingService.logMessage(alertRepository.getEntities());
    }

}
