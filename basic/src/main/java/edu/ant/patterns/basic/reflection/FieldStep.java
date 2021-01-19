package edu.ant.patterns.basic.reflection;

import edu.ant.patterns.basic.exception.MethodCallException;
import java.lang.reflect.Field;

public class FieldStep<T> extends Step<T> {

    private final String fieldName;
    private final Object value;

    FieldStep(Class<T> klazz, String fieldName, Object value) {
        super(klazz);
        this.fieldName = fieldName;
        this.value = value;
    }

    void make(T object) throws NoSuchFieldException {
        Field field = getKlazz().getDeclaredField(fieldName);
        field.setAccessible(true);
        try {
            field.set(object, value);
        } catch (IllegalAccessException e) {
            throw new MethodCallException("Method call failed when set field " + fieldName);
        }
    }

}
