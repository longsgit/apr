package com.herbalife.springbootlab07kafkamongo.repo;

import com.herbalife.springbootlab07kafkamongo.document.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {
}
