package com.herbalife.mongowithspringboot.repo;

import com.herbalife.mongowithspringboot.documents.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {

    List<Person> findAllByAgeGreaterThan(int age);

    List<Person> findAllByFirstName(String firstName);

    @Query(value = "{}", fields = "{'firstName':  1, 'lastName':  1, 'age':  1, 'id':  0}")
    List<Person> getAllPersons();
}
