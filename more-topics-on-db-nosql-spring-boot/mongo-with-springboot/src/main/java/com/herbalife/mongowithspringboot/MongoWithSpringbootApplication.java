package com.herbalife.mongowithspringboot;

import com.herbalife.mongowithspringboot.documents.Person;
import com.herbalife.mongowithspringboot.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoWithSpringbootApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MongoWithSpringbootApplication.class, args);
    }

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
        personRepository.getAllPersons().forEach(System.out::println);

//        personRepository.findAll().forEach(System.out::println);

//        Person person = new Person();
//        person.setFirstName("Ram");
//        person.setLastName("Sharma");
//        person.setAge(32);
//        personRepository.save(person);
    }
}
