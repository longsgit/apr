package com.herbalife.springbootlab01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLab01Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLab01Application.class, args);
    }

    @Autowired
    private Conference conference;

    @Autowired
    private NewAgeConference newAgeConference;

    @Override
    public void run(String... args) throws Exception {
        newAgeConference.get90MinTopics().forEach(System.out::println);
//        newAgeConference.get60MinTopics().forEach(System.out::println);
//        newAgeConference.get45MinTopics().forEach(System.out::println);
    }
}
