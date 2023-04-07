package com.herbalife.examples;

public class OfficeUser {
    public static void main(String[] args) {
        CompanyEmployee emp1 = new CompanyEmployee("Sam");
        CompanyEmployee emp2 = new CompanyEmployee("Ram");
        System.out.println(CompanyEmployee.getOffice());

        //This is not possible in C#
        System.out.println(emp1.getOffice());
        System.out.println(emp2.getOffice());
    }
}
