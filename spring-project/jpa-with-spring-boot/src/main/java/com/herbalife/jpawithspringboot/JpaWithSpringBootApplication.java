package com.herbalife.jpawithspringboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaWithSpringBootApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JpaWithSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
