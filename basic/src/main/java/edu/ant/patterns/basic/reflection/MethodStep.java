package edu.ant.patterns.basic.reflection;

import edu.ant.patterns.basic.exception.MethodCallException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodStep<T> extends Step<T> {

    private final String methodName;
    private final Class<T>[] paramTypes;
    private final Object[] paramValues;

    MethodStep(Class<T> klazz, String methodName, Class<T>[] paramTypes, Object[] paramValues) {
        super(klazz);
        this.methodName = methodName;
        this.paramTypes = paramTypes;
        this.paramValues = paramValues;
    }

    Object make(T object) throws NoSuchMethodException {
        Method method = getKlazz().getMethod(methodName, paramTypes);
        try {
            return method.invoke(object, paramValues);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new MethodCallException("Method call failed when " + methodName);
        }
    }
}
