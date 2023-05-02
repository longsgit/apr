package com.herbalife.lab08consumerapp.service;

import com.herbalife.model.Movie;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    public void processMovie(Movie movie) {
        System.out.println("***RECEIVED " + movie.getTitle());
    }
}
