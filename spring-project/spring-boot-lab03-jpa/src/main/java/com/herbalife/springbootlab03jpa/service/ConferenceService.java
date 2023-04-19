package com.herbalife.springbootlab03jpa.service;

import com.herbalife.springbootlab03jpa.entity.Topic;
import com.herbalife.springbootlab03jpa.exception.TopicFoundException;
import com.herbalife.springbootlab03jpa.exception.TopicNotFoundException;
import com.herbalife.springbootlab03jpa.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ConferenceService {

    @Autowired
    private TopicRepository topicRepository;

    public void addTopic(String title, int duration) {
        Optional<Topic> optionalTopic = topicRepository.findByTitle(title);
        if (optionalTopic.isEmpty()) {
            Topic topic = new Topic();
            topic.setTitle(title);
            topic.setDuration(duration);
            topicRepository.save(topic);
        } else {
            throw new TopicFoundException(title);
        }
    }

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @Transactional
    public void removeTopic(String title) {
        int deletedRowCount = topicRepository.remove(title);
        if(deletedRowCount != 1) {
            throw new TopicNotFoundException(title);
        }
    }

    @Transactional
    public void updateDuration(String title, int duration) {
        int updatedRowCount = topicRepository.updateDuration(title, duration);
        if(updatedRowCount != 1) {
            throw new TopicNotFoundException(title);
        }
    }


//    public void removeTopic(String title) {
//        Optional<Topic> optionalTopic = topicRepository.findByTitle(title);
//        if(optionalTopic.isPresent()) {
//            topicRepository.delete(optionalTopic.get());
//        } else {
//            throw new TopicNotFoundException(title);
//        }
//    }
//
//    public void updateDuration(String title, int duration) {
//        Optional<Topic> optionalTopic = topicRepository.findByTitle(title);
//        if(optionalTopic.isPresent()) {
//            Topic topic = optionalTopic.get();
//            topic.setDuration(duration);
//            topicRepository.save(topic);
//        } else {
//            throw new TopicNotFoundException(title);
//        }
//    }
}
