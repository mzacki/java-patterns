package edu.ant.patterns.persistency.io.json;

import edu.ant.patterns.persistency.io.repository.Alert;
import edu.ant.patterns.utils.json.JsonLoader;
import edu.ant.patterns.utils.json.JsonWriter;
import edu.ant.patterns.utils.logger.LoggingService;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Alert alert = new Alert("purple", "S", "foehn wind", 100);
        JsonWriter.toFile("src/main/resources/io/alert.json", alert);
        JsonWriter.toResources(alert);
        // class needs to have public default constructor
        Alert alert1 = (Alert) JsonLoader.fromFile("src/main/resources/io/alert.json", Alert.class);
        LoggingService.logMsg(alert1.toString());
        // GSON
        String gString = JsonWriter.toGsonString(alert);
        LoggingService.logMsg(gString);
        LoggingService.logMsg(JsonWriter.toGsonObject(gString, Alert.class));
        // array of jsons
        List<Alert> list = AlertLoader.asAlertsInBulk("src/main/resources/io/bulk_alert.json");
        LoggingService.logMsg(list);

    }

}
