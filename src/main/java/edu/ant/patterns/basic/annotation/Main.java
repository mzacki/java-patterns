package edu.ant.patterns.basic.annotation;

import edu.ant.patterns.utils.logger.LoggingService;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Constructor constructor = Record.class.getDeclaredConstructors()[0];
        Arrays.stream(constructor.getParameters())
                .forEach(p -> {
                    Param paramAnnotation = p.getAnnotation(Param.class);
                    String followedVal = paramAnnotation.value();
                    String parameterName = p.getName();
                    LoggingService.logTwoArgs(parameterName, followedVal);
                });

        Record record = new Record(1L, "Data saved: pressure low");

        Map<String, Object> members = new HashMap<>();
        members.put("id", 2L);
        members.put("input", "Incoming alert: heavy rainfall");

        LoggingService.logMsg("Before: " + record);
        restore(record, members);
        LoggingService.logMsg("After: " + record);

    }

    private static void restore(Object o, Map<String, Object> members) {
        Class<?> klazz = o.getClass();
        Arrays.stream(klazz.getDeclaredFields())
                .filter(field -> members.containsKey(field.getName())
                        && field.getAnnotation(Member.class) != null)
                .forEach(field -> {
                    field.setAccessible(true);
                    try {
                        field.set(o, members.get(field.getName()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }

}
