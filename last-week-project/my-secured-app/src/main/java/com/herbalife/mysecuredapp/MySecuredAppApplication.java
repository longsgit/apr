package com.herbalife.mysecuredapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication //(exclude = SecurityAutoConfiguration.class)
public class MySecuredAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySecuredAppApplication.class, args);
    }

}
