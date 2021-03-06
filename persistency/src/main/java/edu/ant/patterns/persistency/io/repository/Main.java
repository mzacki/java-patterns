package edu.ant.patterns.persistency.io.repository;

import edu.ant.patterns.utils.logger.LoggingService;

public class Main {

    public static void main(String[] args) {
        ForecastRepository forecastRepository = new ForecastRepository();
        // GET ALL ENTITIES
        LoggingService.logMsg(forecastRepository.getEntities());
        AlertRepository alertRepository = new AlertRepository();
        LoggingService.logMsg(alertRepository.getEntities());
        // GET BY ID
        LoggingService.logMsg(alertRepository.getById(1L));
        //DELETE BY ID
        alertRepository.deleteById(3L);
        LoggingService.logMsg(alertRepository.getEntities());
        // ADD ENTITY
        Alert alert = new Alert("purple", "S", "foehn wind", 100);
        alertRepository.insert(alert);
        LoggingService.logMsg(alertRepository.getEntities());
        // UPDATE ENTITY
        alert.setLevel("black");
        alertRepository.update(alert);
        LoggingService.logMsg(alertRepository.getEntities());
    }

}
