package com.herbalife.springbootlab01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Conference {

    @Autowired
    private SessionPlanner sessionPlanner;

    public List<String> get90MinTopics() {
        return sessionPlanner.getTopics().get(90);
    }

    public List<String> get45MinTopics() {
        return sessionPlanner.getTopics().get(45);
    }

    public List<String> get60MinTopics() {
        return sessionPlanner.getTopics().get(60);
    }
}
