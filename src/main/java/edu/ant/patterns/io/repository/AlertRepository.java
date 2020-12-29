package edu.ant.patterns.io.repository;


public class AlertRepository extends CustomRepository<Alert> {

    private static final String SOURCE_PATH = "src/main/resources/persistency/alert.txt";
    private static final String DELIMITER = ",";

    @Override
    String createEntry(Alert alert) {
        StringBuilder builder = new StringBuilder();
        builder
                .append(alert.getId()).append(DELIMITER)
                .append(alert.getLevel()).append(DELIMITER)
                .append(alert.getArea()).append(DELIMITER)
                .append(alert.getType()).append(DELIMITER)
                .append(alert.getProbability());
        return builder.toString();
    }

    @Override
    Alert copy(Alert alert) {
        return new Alert(alert);
    }

    @Override
    Alert parseEntry(String entry) {
        String[] items = entry.split(DELIMITER);
        int id = Integer.parseInt(items[0]);
        String level = items[1];
        String area = items[2];
        String type = items[3];
        int probability = Integer.parseInt(items[4]);
        return new Alert(id, level, area, type, probability);
    }

    @Override
    String getSourceFile() {
        return SOURCE_PATH;
    }

}
