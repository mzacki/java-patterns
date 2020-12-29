package edu.ant.patterns.io.repository;


public class ForecastRepository extends CustomRepository<Forecast> {

    private static final String SOURCE_PATH = "src/main/resources/persistency/forecast.txt";
    private static final String DELIMITER = ",";

    @Override
    String createEntry(Forecast forecast) {
        StringBuilder builder = new StringBuilder();
        builder
                .append(forecast.getId()).append(DELIMITER)
                .append(forecast.getFall()).append(DELIMITER)
                .append(forecast.getTemperature()).append(DELIMITER)
                .append(forecast.getPressure()).append(DELIMITER)
                .append(forecast.getWindSpeed());
        return builder.toString();
    }

    @Override
    Forecast copy(Forecast forecast) {
        return new Forecast(forecast);
    }

    @Override
    Forecast parseEntry(String entry) {
        String[] items = entry.split(DELIMITER);
        int id = Integer.parseInt(items[0]);
        String fall = items[1];
        int temperature = Integer.parseInt(items[2]);
        int pressure = Integer.parseInt(items[3]);
        int windSpeed = Integer.parseInt(items[4]);
        return new Forecast(id, fall, temperature, pressure, windSpeed);
    }

    @Override
    String getSourceFile() {
        return SOURCE_PATH;
    }

}
