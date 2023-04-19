package com.herbalife.jpawithspringboot;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonsDao extends JpaRepository<Person, Integer> {
    //findBy and findAllBy methods
    //findByPropertyName or findAllByPropertyName

    List<Person> findAllByFirstName(String firstName); //select * from persons where p.first_name = ?

    List<Person> findAllByFirstNameOrLastName(String firstName, String lastName);

    Optional<Person> findByIdAndFirstName(int id, String firstName);

    List<Person> findAllByFirstNameAndLastNameAndAge(String firstName, String lastName, int age);

    List<Person> findAllByAgeGreaterThan(int age);

    List<Person> findAllByAgeGreaterThanEqual(int age);

    List<Person> findAllByFirstNameOrderByAgeDesc(String firstName);

    List<Person> findAllByFirstNameIn(List<String> firstNames);
}
