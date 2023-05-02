package com.herbalife.lab08consumerapp.consumer;

import com.herbalife.lab08consumerapp.service.MovieService;
import com.herbalife.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class MovieConsumerConfiguration {

    @Autowired
    private MovieService movieService;

    @Bean
    public Consumer<Movie> movieConsumer() {
        return (movie) -> {
            movieService.processMovie(movie);
        };
    }
}
