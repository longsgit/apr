package com.herbalife.springbootlab07kafkamongo.consumer;

import com.herbalife.springbootlab07kafkamongo.model.Movie;
import com.herbalife.springbootlab07kafkamongo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;

@Component
public class MovieConsumer {

    @Autowired
    private MovieService movieService;

    @RetryableTopic(attempts = "3", backoff = @Backoff(delay = 1000, multiplier = 2.0))
    @KafkaListener(topics = "movie-topic", groupId = "movie-consumer-local")
    public void processMovie(Movie movie) {
        System.out.println("*** Received: " + movie);
        if (movie.error()) {
            System.out.println("******* Movie %s has error".formatted(movie.title()));
            throw new RuntimeException("Error in movie %s payload".formatted(movie.title()));
        }
        movieService.addMovie(movie.title(), movie.year());
    }

    @DltHandler
    public void processErrorMovie(Movie movie) {
        System.out.println("*** Processing error movie: " + movie);
        movieService.addMovieWithError(movie.title(), movie.year());
    }
}
