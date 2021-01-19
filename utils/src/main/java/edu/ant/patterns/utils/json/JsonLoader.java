package edu.ant.patterns.utils.json;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import edu.ant.patterns.utils.logger.LoggingService;
import java.io.File;
import java.io.IOException;

public class JsonLoader {

    private JsonLoader() {}

    public static Object fromFile(String path, Class klazz) {
        ObjectMapper objectMapper = new ObjectMapper()
                .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        try {
            return objectMapper.readValue(new File(path), klazz);
        } catch (IOException e) {
            LoggingService.logError(e);
        }
        return null;
    }

}
