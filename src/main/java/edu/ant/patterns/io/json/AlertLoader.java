package edu.ant.patterns.io.json;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import edu.ant.patterns.io.repository.Alert;
import edu.ant.patterns.utils.logger.LoggingService;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AlertLoader {

    private AlertLoader() {}

    public static List<Alert> asAlertsInBulk(String path) {
        ObjectMapper objectMapper = new ObjectMapper()
                .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        try {
            return Arrays.asList(objectMapper.readValue(new File(path), Alert[].class));
        } catch (IOException e) {
            LoggingService.logError(e);
        }
        return Collections.emptyList();
    }

}
