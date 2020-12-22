package edu.ant.patterns.basic.reflection;

import edu.ant.patterns.basic.annotation.Record;

public class Main {

    /**
     * USE OF REFLECTION MECHANISM - EXAMPLES
     * PLEASE USE IT REASONABLY, SEE java:S3011
     * */

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Record record = new Record(1L, "Incoming storm");
        // READING DECLARED FIELDS
        // generic method
        ReflectionUtils.logDeclaredFields(record, Record.class, "id", "input");
        // SETTING DECLARED FIELDS
        // generic method
        ReflectionUtils.setDeclaredField(record, Record.class, "input", "Incoming severe storm");

    }


}
