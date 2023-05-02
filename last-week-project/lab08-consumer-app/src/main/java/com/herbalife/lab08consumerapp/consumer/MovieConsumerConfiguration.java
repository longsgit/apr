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

//        return new MovieConsumerImpl();

//        return new Consumer<Movie>() {
//            @Override
//            public void accept(Movie movie) {
//                movieService.processMovie(movie);
//            }
//        };

        return (Movie movie) -> {
            movieService.processMovie(movie);
        };
    }
}

class MovieConsumerImpl implements Consumer<Movie> {
    @Override
    public void accept(Movie movie) {
        //process movie here
    }
}