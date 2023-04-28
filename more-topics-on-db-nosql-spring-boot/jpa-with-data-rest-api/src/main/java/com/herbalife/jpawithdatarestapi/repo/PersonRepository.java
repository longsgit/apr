package com.herbalife.jpawithdatarestapi.repo;

import com.herbalife.jpawithdatarestapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
