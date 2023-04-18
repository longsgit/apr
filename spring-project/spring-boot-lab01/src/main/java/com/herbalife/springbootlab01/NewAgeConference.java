package com.herbalife.springbootlab01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
//@ConfigurationProperties(prefix = "new-age-conference")
public class NewAgeConference {
    @Autowired
    private List<Topic> topics;

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public List<String> get90MinTopics() {
        return topics
                .stream()
                .filter(t -> t.getDuration() == 90)
                .map(t -> t.getTitle())
                .collect(Collectors.toList());
    }

    public List<String> get45MinTopics() {
        return topics
                .stream()
                .filter(t -> t.getDuration() == 45)
                .map(t -> t.getTitle())
                .collect(Collectors.toList());
    }

    public List<String> get60MinTopics() {
        return topics
                .stream()
                .filter(t -> t.getDuration() == 60)
                .map(t -> t.getTitle())
                .collect(Collectors.toList());
    }
}
