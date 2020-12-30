package edu.ant.patterns.utils.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.ant.patterns.utils.logger.LoggingService;
import java.io.File;
import java.io.IOException;

public class JsonWriter {

    private static final String RESOURCES = "src/main/resources/";
    private static final String EXTENSION = ".json";

    private JsonWriter() {}

    public static void toFile(String path, Object o) {
        try {
            new ObjectMapper()
                    .writeValue(new File(path), o);
        } catch (IOException e) {
            LoggingService.logError(e);
        }
    }

    public static void toResources(Object o) {
        String fileName = o.getClass().getSimpleName().concat(EXTENSION);
        try {
            new ObjectMapper()
                    .writeValue(new File(RESOURCES.concat(fileName)), o);
        } catch (IOException e) {
            LoggingService.logError(e);
        }
    }

    public static String toGsonString(Object o) {
        Gson gson = new GsonBuilder().setPrettyPrinting()
                .create();
        return gson.toJson(o);
    }

    public static Object toGsonObject(String s, Class klazz) {
        Gson gson = new GsonBuilder().setPrettyPrinting()
                .create();
      return gson.fromJson(s, klazz);
    }

}
