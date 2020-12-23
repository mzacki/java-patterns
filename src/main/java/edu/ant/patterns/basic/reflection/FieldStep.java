package edu.ant.patterns.basic.reflection;

import java.lang.reflect.Field;

public class FieldStep<T> extends Step<T> {

    private final String fieldName;
    private final Object value;

    FieldStep(Class<T> klazz, String fieldName, Object value) {
        super(klazz);
        this.fieldName = fieldName;
        this.value = value;
    }

    void make(T object) throws NoSuchFieldException, IllegalAccessException {
        Field field = getKlazz().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(object, value);
    }

}
