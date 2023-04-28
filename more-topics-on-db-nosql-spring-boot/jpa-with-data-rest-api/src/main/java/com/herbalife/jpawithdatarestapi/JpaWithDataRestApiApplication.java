package com.herbalife.jpawithdatarestapi;

import com.herbalife.jpawithdatarestapi.entity.Topic;
import com.herbalife.jpawithdatarestapi.repo.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@SpringBootApplication
public class JpaWithDataRestApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JpaWithDataRestApiApplication.class, args);
    }

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public void run(String... args) throws Exception {
        Pageable pageable = Pageable.ofSize(2).withPage(1);
        Page<Topic> topicsPage = topicRepository.findAll(pageable);
        topicsPage.getContent().forEach(System.out::println);

        System.out.println();

        Pageable pageable2 = Pageable.ofSize(2).withPage(2);
        Page<Topic> topicsPage2 = topicRepository.findAll(pageable2);
        topicsPage2.getContent().forEach(System.out::println);
    }
}
