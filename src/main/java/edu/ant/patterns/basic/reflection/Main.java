package edu.ant.patterns.basic.reflection;

import edu.ant.patterns.basic.annotation.Record;
import edu.ant.patterns.basic.annotation.Tuple;
import edu.ant.patterns.basic.exception.NoSuchConstructorException;
import edu.ant.patterns.utils.logger.LoggingService;
import java.lang.reflect.InvocationTargetException;

public class Main {

    /**
     * USE OF REFLECTION MECHANISM - EXAMPLES
     * PLEASE USE IT WITH PRUDENCE, SEE java:S3011
     * */

    public static void main(String[] args)
            throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Record record = new Record(1L, "Incoming storm");
        // READING DECLARED FIELDS
        ReflectionUtils.logDeclaredFields(record, Record.class, "id", "input");
        // SETTING DECLARED FIELDS
        ReflectionUtils.setDeclaredField(record, Record.class, "input", "Incoming severe storm");
        // INVOKE METHOD
        ReflectionUtils.invokeMethod(record, Record.class, "getInput");
        // INVOKE DECLARED METHODS
        ReflectionUtils.invokeGetters(record, Record.class);
        // INVOKE CONSTUCTOR
        LoggingService.logMessage(ReflectionUtils.getInstance(Record.class, 2,1L, "input"));
        LoggingService.logMessage(ReflectionUtils.getInstance(Record.class, 1,1L));
        // CONSTRUCT STEP
        constructStep();
        // FIELD STEP
        fieldStep();
        // METOD STEP
        methodStep();
        // GET CONSTRUCTOR
        try {
            LoggingService.logMessage(ReflectionUtils.getConstructor(Record.class));
            LoggingService.logMessage(ReflectionUtils.getConstructor(Tuple.class));
        } catch (NoSuchConstructorException e) {
            LoggingService.logError(e);
        }

    }

    private static void constructStep() throws NoSuchConstructorException {
        ConstructorStep<Record> constructorStep = new ConstructorStep<>(Record.class, new Class[]{long.class, String.class},
                new Object[]{99L, "record constructed by step"});
        LoggingService.logMessage(constructorStep.make());
    }

    private static void fieldStep() throws NoSuchFieldException {
        Record record = new Record(0L, "initial input");
        LoggingService.logMessage(record);
        FieldStep<Record> fieldStep = new FieldStep<>(Record.class, "input", "input update");
        fieldStep.make(record);
        LoggingService.logMessage(record);
    }

    private static void methodStep() throws NoSuchMethodException {
        Record record = new Record(0L, "initial input");
        LoggingService.logMessage(record);
        MethodStep<Record> methodStep = new MethodStep<>(Record.class, "setInput", new Class[]{String.class},
                new Object[]{"input injected by method step"});
        methodStep.make(record);
        LoggingService.logMessage(record);
        LoggingService.logMessage(methodStep.getType());
    }

}
