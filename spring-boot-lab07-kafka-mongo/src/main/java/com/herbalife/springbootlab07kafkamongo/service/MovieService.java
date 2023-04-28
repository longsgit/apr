package com.herbalife.springbootlab07kafkamongo.service;

import com.herbalife.springbootlab07kafkamongo.document.ErrorMovie;
import com.herbalife.springbootlab07kafkamongo.document.Movie;
import com.herbalife.springbootlab07kafkamongo.repo.ErrorMovieRepository;
import com.herbalife.springbootlab07kafkamongo.repo.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ErrorMovieRepository errorMovieRepository;

    public void addMovie(String title, int year) {
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setYear(year);
        movieRepository.save(movie);
    }

    public void addMovieWithError(String title, int year) {
        ErrorMovie errorMovie = new ErrorMovie();
        errorMovie.setTitle(title);
        errorMovie.setYear(year);
        errorMovieRepository.save(errorMovie);
    }
}
