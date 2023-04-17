package com.herbalife.examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DoorUser {
    public static void main(String[] args) {
        //ApplicationContext acts as a container; It acts as a factory
        //It creates all the components; Manages the lifecycle of the components
        ApplicationContext container = new FileSystemXmlApplicationContext("classpath:beans.xml");

        Person person = container.getBean("person", Person.class);
        person.driveToOffice();

        Door door = container.getBean("door", Door.class);
//        Door door = new Door();
//        Alarm alarm = new Alarm();
//        door.setAlarm(alarm);
        door.open();
        door.close();
//
//        Car car = container.getBean("car", Car.class);
//        System.out.println(car);
//
//        Person person = container.getBean("person", Person.class);
//        System.out.println(person);
    }
}
