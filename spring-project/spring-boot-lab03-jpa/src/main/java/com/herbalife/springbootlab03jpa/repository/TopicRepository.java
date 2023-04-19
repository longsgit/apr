package com.herbalife.springbootlab03jpa.repository;

import com.herbalife.springbootlab03jpa.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Integer> {

    @Modifying
    @Query(value = "Update Topic t set t.duration = :duration where t.title = :title")
    int updateDuration(@Param("title") String title, @Param("duration") int duration);

    @Modifying
    @Query(value = "delete from Topic t where t.title = :title")
    int remove(@Param("title") String title);

    Optional<Topic> findByTitle(String title);


}
