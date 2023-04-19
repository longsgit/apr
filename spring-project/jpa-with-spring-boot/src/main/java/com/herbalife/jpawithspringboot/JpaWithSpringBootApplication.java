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
    private PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
//        reflectPersonsDao();
//        basicCRUDOperations();
//        finderMethods();

        //personsDao.computePersonsWithAgeBetween(10, 50).forEach(System.out::println);

        //personsDao.updateAge(1, 67); //Will not work because the method needs a transaction
        //personsDao.deletePerson(1); //Will not work because the method needs a transaction
    }



    private void finderMethods() {
        personRepository
                .findAllByAgeGreaterThan(10)
                .forEach(System.out::println);

        personRepository
                .findAllByFirstNameOrderByAgeDesc("Sam")
                .forEach(System.out::println);
        personRepository
                .findAllByFirstNameIn(Arrays.asList("Sam", "Ram", "Mary", "Martin"))
                .forEach(System.out::println);
    }

    private void reflectPersonsDao() {
        System.out.println("******* " + personRepository.getClass().getName());
        for (Class cls : personRepository.getClass().getInterfaces()) {
            System.out.println(cls.getName());
        }
        System.out.println();
    }

    private void basicCRUDOperations() {
        Person person = new Person();
        person.setFirstName("Long");
        person.setLastName("Sheng");
        person.setAge(30);
        personRepository.save(person); //insert into persons(first_name) values(?);
        //insert into persons(first_name) values('" + firstName + "'); //Prone to SQL injections

        personRepository.findAll().forEach(System.out::println);

        //update the age of a person with id 1
        Optional<Person> optionalPerson = personRepository.findById(1);
        if (optionalPerson.isPresent()) {
            Person p = optionalPerson.get();
            p.setAge(p.getAge() + 1);//keeping it simple
            personRepository.save(p); //update
        }

        //delete the person with id 1
        Optional<Person> optionalPerson2 = personRepository.findById(2);
        if (optionalPerson2.isPresent()) {
            Person p = optionalPerson2.get();
            personRepository.delete(p);
        }
    }
}
