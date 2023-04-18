package com.herbalife.springbootlab01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfiguration {
    @Bean
    public List<Topic> topics() {
        return Arrays.asList(new Topic("GoG", 90),
                new Topic("Grpc", 60),
                new Topic("Kafka", 45));
    }
}
