package com.example.springbootmoreonrestapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Used to develop REST API
//All the methods return data
@RestController
public class SampleController {

    @Value("${welcome}")
    private String welcome;

    @GetMapping("/hello")
    public String greet() {
        return welcome;
    }
}
