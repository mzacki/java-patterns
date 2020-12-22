package edu.ant.patterns.basic.reflection;

import edu.ant.patterns.basic.annotation.Record;
import java.lang.reflect.InvocationTargetException;

public class Main {

    /**
     * USE OF REFLECTION MECHANISM - EXAMPLES
     * PLEASE USE IT REASONABLY, SEE java:S3011
     * */

    public static void main(String[] args)
            throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Record record = new Record(1L, "Incoming storm");
        // READING DECLARED FIELDS
        ReflectionUtils.logDeclaredFields(record, Record.class, "id", "input");
        // SETTING DECLARED FIELDS
        ReflectionUtils.setDeclaredField(record, Record.class, "input", "Incoming severe storm");
        // INVOKE METHOD
        ReflectionUtils.invokeMethod(record, Record.class, "getInput");
        // INVOKE DECLARED METHODS
        ReflectionUtils.invokeGetters(record, Record.class);
    }


}
