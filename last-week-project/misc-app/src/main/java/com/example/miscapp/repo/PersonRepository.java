package com.example.miscapp.repo;

import com.example.miscapp.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

//http://localhost:8081/persons?page=1&size=3
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
