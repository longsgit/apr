package com.herbalife.examples;

import com.herbalife.examples.one.Car;
import com.herbalife.examples.one.Greetings;
import com.herbalife.examples.one.Vehicle;
//import com.herbalife.examples.one.Sample;

public class AccessSpecifiersMain {
    public static void main(String[] args) {
        Greetings greetings = new Greetings();
        //greetings.message = "Hello";
        greetings.message2 = "Bye";
        Car bmw = new Car("e123124");
        //System.out.println(bmw.getChassisNo());

    }
}
class Truck extends Vehicle {
    public Truck(String chassisNo) {
        this.chassisNo = chassisNo;
    }
}
