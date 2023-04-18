package com.herbalife.springbootbasics;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class TuesdayConfiguration {

    @Bean
    public List<String> topicsInSpringBootCourse() {
        //You can go to DB and fetch the topics and construct the list
        return Arrays.asList("REST", "Kafka", "Security", "JPA");
    }

    @Bean
    public List<String> topicsInGolangCourse() {
        //You can go to DB and fetch the topics and construct the list
        return Arrays.asList("Struct", "Pointers", "interface{}", "json");
    }
}
