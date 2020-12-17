package edu.ant.patterns.basic.reflection;

import edu.ant.patterns.utils.logger.LoggingService;
import java.lang.reflect.Field;

public class ReflectionUtils {

    private ReflectionUtils() {}

    static <T> void logDeclaredFields(Object o, Class<T> klazz, String... args)
            throws NoSuchFieldException, IllegalAccessException {

        for (String s : args) {
            Field field = klazz.getDeclaredField(s);
            field.setAccessible(true);
            LoggingService.logTwoArgs(field.getName(), field.get(o));
        }
    }

}
