package com.herbalife.jpawithspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Optional;

@SpringBootApplication
public class JpaWithSpringBootApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JpaWithSpringBootApplication.class, args);
    }

    @Autowired
    private PersonsDao personsDao;

    @Override
    public void run(String... args) throws Exception {
//        reflectPersonsDao();
//        basicCRUDOperations();

        personsDao
                .findAllByAgeGreaterThan(10)
                .forEach(System.out::println);

        personsDao
                .findAllByFirstNameOrderByAgeDesc("Sam")
                .forEach(System.out::println);
        personsDao
                .findAllByFirstNameIn(Arrays.asList("Sam", "Ram", "Mary", "Martin"))
                .forEach(System.out::println);

    }

    private void reflectPersonsDao() {
        System.out.println("******* " + personsDao.getClass().getName());
        for (Class cls : personsDao.getClass().getInterfaces()) {
            System.out.println(cls.getName());
        }
        System.out.println();
    }

    private void basicCRUDOperations() {
        Person person = new Person();
        person.setFirstName("Long");
        person.setLastName("Sheng");
        person.setAge(30);
        personsDao.save(person); //insert into persons(first_name) values(?);
        //insert into persons(first_name) values('" + firstName + "'); //Prone to SQL injections

        personsDao.findAll().forEach(System.out::println);

        //update the age of a person with id 1
        Optional<Person> optionalPerson = personsDao.findById(1);
        if (optionalPerson.isPresent()) {
            Person p = optionalPerson.get();
            p.setAge(p.getAge() + 1);//keeping it simple
            personsDao.save(p); //update
        }

        //delete the person with id 1
        Optional<Person> optionalPerson2 = personsDao.findById(2);
        if (optionalPerson2.isPresent()) {
            Person p = optionalPerson2.get();
            personsDao.delete(p);
        }
    }
}
