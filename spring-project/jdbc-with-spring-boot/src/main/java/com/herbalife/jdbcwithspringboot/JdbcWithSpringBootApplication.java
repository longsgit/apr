package com.herbalife.jdbcwithspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcWithSpringBootApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JdbcWithSpringBootApplication.class, args);
    }

    @Autowired
    private PersonsDao personsDao;

    @Override
    public void run(String... args) throws Exception {
        personsDao.getAllPersons().forEach(record -> {
            record.forEach((col, value) -> System.out.println(col + ": " + value));
            System.out.println();
        });
//        personsDao.getAllFirstNames().forEach(System.out::println);
//        personsDao.insert("Mary", "Joe", 34);
//        personsDao.delete(3);
//        personsDao.delete(4);
    }
}
