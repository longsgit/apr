package com.herbalife.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    @Autowired
    private Car car;

    public void driveToOffice() {
        System.out.println("Using " + car + " to go to the office");
    }
}
