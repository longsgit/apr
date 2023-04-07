package com.herbalife.examples;

//super class
public class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public final void swipeInForWork() {
        System.out.println("Swiping in my card");
    }

    //overridable
    public void work(int hours) {
        System.out.println("Employee is working " + hours + " hours");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
