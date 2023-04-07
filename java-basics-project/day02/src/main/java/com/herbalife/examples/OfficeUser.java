package com.herbalife.examples;

public class OfficeUser {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Sam");
        Employee emp2 = new Employee("Ram");
        System.out.println(Employee.getOffice());

        //This is not possible in C#
        System.out.println(emp1.getOffice());
        System.out.println(emp2.getOffice());
    }
}
