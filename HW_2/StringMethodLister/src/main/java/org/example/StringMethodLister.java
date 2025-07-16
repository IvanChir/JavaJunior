package org.example;

import java.lang.reflect.Method;

public class StringMethodLister {
    public void listStringMethods() {
        Class<String> stringClass = String.class;
        Method[] methods = stringClass.getDeclaredMethods();

        System.out.println("Методы класса String:");
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}