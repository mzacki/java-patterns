package edu.ant.patterns.basic.reflection;

import edu.ant.patterns.basic.annotation.Param;
import edu.ant.patterns.basic.exception.NoSuchConstructorException;
import edu.ant.patterns.utils.logger.LoggingService;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    static <T> void setDeclaredField(Object o, Class<T> klazz, String fieldName, Object value)
            throws NoSuchFieldException, IllegalAccessException {
            Field field = klazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(o, value);
            LoggingService.logTwoArgs(field.getName(), field.get(o));
    }

    static <T> void invokeMethod(Object o, Class<T> klazz, String methodName)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
      LoggingService.logMessage(klazz.getMethod(methodName).invoke(o));
    }

    static <T> void invokeGetters(Object o, Class<T> klazz) {
        List<Method> methods = Arrays.stream(klazz.getDeclaredMethods())
                .filter(m -> m.getName().startsWith("get") || m.getName().startsWith("is"))
                .filter(m -> m.getParameterCount() == 0)
                .filter(m -> Modifier.isPublic(m.getModifiers()))
                .collect(Collectors.toList());

        methods.forEach(m -> {
            try {
                LoggingService.logTwoArgs(m.getName(), m.invoke(o));
            } catch (IllegalAccessException | InvocationTargetException e) {
                LoggingService.logError(e);
            }
        });
    }

    static <T> T getInstance(Class<T> klazz, int paramCount, Object... args)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?>[] params = Arrays.stream(klazz.getConstructors())
                .filter(c -> c.getParameterCount() == paramCount)
                .map(Constructor::getParameterTypes)
                .findFirst().orElseThrow();

        Constructor<T> constructor = klazz.getConstructor(params);

        return constructor.newInstance(args);
    }

    /**
     * returns public constructor with the least number of params
     * if more than one found, returns first
     * if primitive passed uses wrapper class
     * */

    static <T> T getConstructor(Class<T> klazz) throws NoSuchConstructorException {
        return (T) Arrays.stream(getWrapper(klazz).getConstructors())
                .min(Comparator.comparingInt(Constructor::getParameterCount))
                .orElseThrow(() -> new NoSuchConstructorException("No public constructor available for class " + klazz.getName()));
    }

    static Class getWrapper(Class klazz) {

        if(klazz.isPrimitive()) {
            Map<Class, Class> map = new HashMap<>();
            map.put(byte.class, Byte.class);
            map.put(short.class, Short.class);
            map.put(int.class, Integer.class);
            map.put(long.class, Long.class);
            map.put(float.class, Float.class);
            map.put(double.class, Double.class);
            map.put(char.class, Character.class);
            map.put(boolean.class, Boolean.class);

            return map.get(klazz);
        }

        return klazz;
    }

    public static String getParam(Parameter parameter) {
        Param annotation = parameter.getDeclaredAnnotation(Param.class);
        return annotation != null ? annotation.value() : parameter.getName();
    }


}
