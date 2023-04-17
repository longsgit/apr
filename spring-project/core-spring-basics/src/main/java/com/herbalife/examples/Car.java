package com.herbalife.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car {

    @Value("BMW")
    private String model;

    @Autowired
    private Door leftFrontDoor;
    @Autowired
    private Door rightFrontDoor;
    @Autowired
    private Door leftRearDoor;
    @Autowired
    private Door rightRearDoor;

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                '}';
    }

    public Door getLeftFrontDoor() {
        return leftFrontDoor;
    }

    public Door getRightFrontDoor() {
        return rightFrontDoor;
    }

    public Door getLeftRearDoor() {
        return leftRearDoor;
    }

    public Door getRightRearDoor() {
        return rightRearDoor;
    }
}
