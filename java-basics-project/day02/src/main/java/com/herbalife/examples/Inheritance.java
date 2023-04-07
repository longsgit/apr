package com.herbalife.examples;

public class Inheritance {
    public static void main(String[] args) {
        Manager sam = new Manager(120, "Sam");
        Manager ram = new Manager(121, "Ram");
        ram.work(8);
        sam.work(10);

        Employee emp = new Manager(122, "Joe");
        emp.work(12);
    }
}
