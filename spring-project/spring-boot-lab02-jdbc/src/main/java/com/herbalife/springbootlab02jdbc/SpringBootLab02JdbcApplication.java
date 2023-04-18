package com.herbalife.springbootlab02jdbc;

import com.herbalife.springbootlab02jdbc.exception.TopicFoundException;
import com.herbalife.springbootlab02jdbc.exception.TopicNotFoundException;
import com.herbalife.springbootlab02jdbc.service.ConferenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLab02JdbcApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLab02JdbcApplication.class, args);
    }

    private static Logger logger = LoggerFactory.getLogger(SpringBootLab02JdbcApplication.class);

    @Autowired
    private ConferenceService conferenceService;


    @Override
    public void run(String... args) throws Exception {
        try {
            conferenceService.addTopic("Cloudevents", 90);
            conferenceService.addTopic("KrakenD", 65);
            conferenceService.addTopic("Backstage", 90);
        } catch (TopicFoundException e) {
            logger.error("Topic found: {}", e.getMessage());
            //System.out.println("Error: Topic found: %s".formatted(e.getMessage()));
        }

        try {
            conferenceService.removeTopic("Scala Tricks");
        } catch (TopicNotFoundException e) {
            logger.error("Topic not found: {}", e.getMessage());
            //System.out.println("Error: Topic not found: %s".formatted(e.getMessage()));
        }

        conferenceService.getAllTopicRecords().forEach(System.out::println);
    }
}
