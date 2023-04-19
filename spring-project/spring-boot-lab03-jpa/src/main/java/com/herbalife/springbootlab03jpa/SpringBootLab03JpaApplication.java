package com.herbalife.springbootlab03jpa;

import com.herbalife.springbootlab03jpa.exception.TopicFoundException;
import com.herbalife.springbootlab03jpa.exception.TopicNotFoundException;
import com.herbalife.springbootlab03jpa.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLab03JpaApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(SpringBootLab03JpaApplication.class, args);
    }


    @Autowired
    private ConferenceService conferenceService;

    @Override
    public void run(String... args) throws Exception {
        try {
            conferenceService.addTopic("Cloudevents", 90);
            conferenceService.addTopic("KrakenD", 65);
            conferenceService.addTopic("Backstage", 90);
        } catch (TopicFoundException e) {
            //logger.error("Topic found: {}", e.getMessage());
            System.out.println("Error: Topic found: %s".formatted(e.getMessage()));
        }

        try {
            conferenceService.removeTopic("Scala Tricks");
        } catch (TopicNotFoundException e) {
            //logger.error("Topic not found: {}", e.getMessage());
            System.out.println("Error: Topic not found: %s".formatted(e.getMessage()));
        }
        conferenceService.updateDuration("KrakenD", 60);
        conferenceService.removeTopic("Kong");
        conferenceService.getAllTopics().forEach(System.out::println);
    }
}
