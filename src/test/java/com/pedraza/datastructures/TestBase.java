package com.pedraza.datastructures;

import java.lang.reflect.Field;

public class TestBase {
    public Object getField(Object instance, String fieldName) {
        try {
            Class<?> theClass = instance.getClass();
            Field field = theClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            Object value = field.get(instance);
            return value;
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}