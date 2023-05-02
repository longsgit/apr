package com.herbalife.lab08consumerkafkaapp;

import com.herbalife.model.Movie;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MovieConsumer {
    @KafkaListener(topics = "movie-topic", groupId = "movie-consumer-kafka-local")
    public void processMovie(Movie movie) {
        System.out.println("***Received " + movie.getTitle());
    }
}
