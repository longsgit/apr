package com.herbalife.springbootlab07kafkamongo.repo;

import com.herbalife.springbootlab07kafkamongo.document.ErrorMovie;
import com.herbalife.springbootlab07kafkamongo.document.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ErrorMovieRepository extends MongoRepository<ErrorMovie, String> {
}
