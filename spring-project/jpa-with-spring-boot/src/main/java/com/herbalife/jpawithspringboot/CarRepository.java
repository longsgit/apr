package com.herbalife.jpawithspringboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query(value = "select c from Car c join fetch c.owner where c.id = :carId")
    Car fetchCarWithPersonDetails(@Param("carId") int id);
}
