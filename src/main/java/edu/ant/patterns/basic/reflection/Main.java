package edu.ant.patterns.basic.reflection;

import edu.ant.patterns.basic.annotation.Record;
import edu.ant.patterns.utils.logger.LoggingService;
import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        logFields();
        // generic method
        ReflectionUtils.logDeclaredFields(new Record(1L, "Incoming storm"), Record.class, "id", "input");
    }

    private static void logFields() throws NoSuchFieldException, IllegalAccessException {
        Record record = new Record(1L, "Incoming storm");
        Class<Record> klazz = Record.class;
        Field idField = klazz.getDeclaredField("id");
        // Sonar complaint
        idField.setAccessible(true);
        // change getLong to simple get if type unknown
        LoggingService.logTwoArgs(idField.getName(), idField.getLong(record));
    }

}
