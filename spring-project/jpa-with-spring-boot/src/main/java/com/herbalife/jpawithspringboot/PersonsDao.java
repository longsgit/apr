package com.herbalife.jpawithspringboot;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonsDao extends JpaRepository<Person, Integer> {
}
