package com.herbalife.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {

    @Value("Sam")
    private String name;

    @Autowired
    private Car car;

    public void driveToOffice() {
        car.getLeftFrontDoor().open();
        car.getLeftFrontDoor().close();
        System.out.println(this.name + " is using " + car + " to go to the office");
    }
}
