package com.herbalife.jpawithspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JpaWithSpringBootApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JpaWithSpringBootApplication.class, args);
    }

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private DogRepository dogRepository;

    @Override
    public void run(String... args) throws Exception {

        Dog snoopy = new Dog();
        snoopy.setName("Snoopy");
        dogRepository.save(snoopy);

        Dog rover = new Dog();
        rover.setName("Rover");
        dogRepository.save(rover);

        Person virat = new Person();
        virat.setFirstName("Virat");
        virat.setLastName("Kohli");
        virat.setAge(35);
        List<Dog> pets = new ArrayList<>();
        pets.add(snoopy);
        pets.add(rover);
        virat.setDogs(pets);
        personRepository.save(virat);



//        System.out.println("*******FETCH WITHOUT PERSON DETAILS");
//        Car car = carRepository.findById(1).get();
//        System.out.println(car.getModel());
//
//        System.out.println("*******FETCH ALONG WITH PERSON DETAILS");
//        Car car2 = carRepository.fetchCarWithPersonDetails(2);
//        System.out.println(car2.getModel());
//        System.out.println(car2.getOwner());


//        Person joe = new Person();
//        joe.setFirstName("Joe");
//        joe.setLastName("Martin");
//        joe.setAge(40);
//        personRepository.save(joe);
//
//        Car bmw = new Car();
//        bmw.setModel("BMW 8");
//        bmw.setYear(2020);
//        bmw.setOwner(joe);
//
//        Car tesla = new Car();
//        tesla.setModel("TESLA");
//        tesla.setYear(2022);
//        tesla.setOwner(joe);
//
//        carRepository.save(bmw);
//        carRepository.save(tesla);

//        reflectPersonsDao();
//        basicCRUDOperations();
//        finderMethods();

//        personsDao.computePersonsWithAgeBetween(10, 50).forEach(System.out::println);
//
//        personsDao.updateAge(1, 67); //Will not work because the method needs a transaction
//        personsDao.deletePerson(1); //Will not work because the method needs a transaction
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
