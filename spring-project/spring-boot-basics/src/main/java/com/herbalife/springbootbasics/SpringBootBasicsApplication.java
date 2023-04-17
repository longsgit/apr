package com.herbalife.springbootbasics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootBasicsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBasicsApplication.class, args);
    }

    @Autowired
    private Car car;

    @Autowired
    private Person person;

    @Autowired
    private Training training;

    @Autowired
    private Door door1;

    @Autowired
    private Door door2;

    @Autowired
    private Door door3;

    @Autowired
    private Company company;

    @Autowired
    private BookStore bookStore;

    @Override
    public void run(String... args) throws Exception {
        //STARTING POINT FOR YOUR APPLICATION
        //EXECUTES AFTER APPLICATIONCONTEXT IS CREATED AND ALL THE BEANS ARE LOADED

        System.out.println(bookStore);

//        System.out.println(company.getName() + ", " + company.getNumberOfEmployees());
//        company.getCountries().forEach(System.out::println);

//        System.out.println(door1);
//        System.out.println(door2);
//        System.out.println(door3);

//        System.out.println(car.getModel());
//        System.out.println(person.getName());
    }
}
