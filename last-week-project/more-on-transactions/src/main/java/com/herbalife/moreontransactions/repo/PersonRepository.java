package com.herbalife.moreontransactions.repo;

import com.herbalife.moreontransactions.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
