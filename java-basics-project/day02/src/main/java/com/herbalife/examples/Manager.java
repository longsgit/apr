package com.herbalife.examples;

//sub class
//class Manager : Employee {}
public final class Manager extends Employee {

    public Manager(int id, String name) {
        super(id, name);
    }

    //override
    public void work(int hours) {
        System.out.println("Manager is working  " + hours + " hours");
    }
}

class SeniorManager extends Employee {
    public SeniorManager(int id, String name) {
        super(id, name);
    }
}