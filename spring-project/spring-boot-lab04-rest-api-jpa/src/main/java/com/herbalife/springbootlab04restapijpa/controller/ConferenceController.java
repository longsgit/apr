package com.herbalife.springbootlab04restapijpa.controller;

import com.herbalife.springbootlab04restapijpa.dto.TopicDto;
import com.herbalife.springbootlab04restapijpa.entity.Topic;
import com.herbalife.springbootlab04restapijpa.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//mapping -> do not use verbs; use nouns; because you have HTTP verbs
//root mapping is a plural

@RestController
@RequestMapping("/conference/topics")
public class ConferenceController {

    @Autowired
    private ConferenceService conferenceService;

    @PostMapping
    public HttpEntity<Void> addTopic(@RequestBody TopicDto topicDto) {
        conferenceService.addTopic(topicDto.getTitle(), topicDto.getDuration());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<Topic> getAllTopics() {
        return conferenceService.getAllTopics();
    }

}
