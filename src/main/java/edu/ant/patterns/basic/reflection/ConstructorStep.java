package edu.ant.patterns.basic.reflection;

import edu.ant.patterns.basic.exception.ConstructorCallException;
import edu.ant.patterns.basic.exception.NoSuchConstructorException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorStep<T> extends Step<T> {

    private final Class<T>[] paramTypes;
    private final Object[] paramValues;

    public ConstructorStep(Class<T> klazz, Class<T>[] paramTypes, Object[] paramValues) {
        super(klazz);
        this.paramTypes = paramTypes;
        this.paramValues = paramValues;
    }

    T make() throws NoSuchConstructorException {
        Constructor<T> constructor;
        try {
            constructor = getKlazz().getConstructor(paramTypes);
        } catch (NoSuchMethodException e) {
            throw new NoSuchConstructorException("No such constructor for class " + getKlazz().getName());
        }
        try {
            return constructor.newInstance(paramValues);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new ConstructorCallException("Constructor call failed for class " + getKlazz().getName());
        }
    }

}
