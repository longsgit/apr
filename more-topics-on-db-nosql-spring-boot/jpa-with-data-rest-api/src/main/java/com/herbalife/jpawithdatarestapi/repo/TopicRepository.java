package com.herbalife.jpawithdatarestapi.repo;

import com.herbalife.jpawithdatarestapi.entity.Person;
import com.herbalife.jpawithdatarestapi.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TopicRepository extends PagingAndSortingRepository<Topic, Integer> {
    List<Topic> findAllByDuration(int duration);
    List<Topic> findAllByDurationBetween(int start, int end);
}
