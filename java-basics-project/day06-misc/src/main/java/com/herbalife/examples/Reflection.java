package com.herbalife.examples;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, InstantiationException {
        //Type.GetType
        //Class
        Class personCls = Class.forName("com.herbalife.examples.Person");
        System.out.println(personCls.getName());
        System.out.println(personCls.getSuperclass().getName());
        Constructor constructor = personCls.getConstructor(new Class[]{String.class, int.class});
        Object personInstance = constructor.newInstance("Ram", 34);
        System.out.println(personInstance);

        Person sam = new Person("Sam", 12);
        Class personClass = sam.getClass();
        Field[] fields = personClass.getDeclaredFields();
        for (Field field: fields) {
            field.setAccessible(true);
            System.out.println(field.getName());
            System.out.println(field.get(sam));
        }
        Method[] methods = personClass.getDeclaredMethods();
        for (Method method: methods) {
            System.out.println(method.getName());
            if("eat".equalsIgnoreCase(method.getName())) {
                method.invoke(sam, "Bread");
            }
        }
        for(Annotation annotation : personClass.getDeclaredAnnotations()) {
            if(annotation instanceof Entity) {
                System.out.println("Entity annotation is present");
            }
        }
    }
}
@Entity
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat(String item) {
        System.out.println(this.name + " is eating " + item);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
