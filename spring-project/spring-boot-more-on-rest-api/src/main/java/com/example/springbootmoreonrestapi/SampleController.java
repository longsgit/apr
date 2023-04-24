package com.example.springbootmoreonrestapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Used to develop REST API
//All the methods return data
@RestController
public class SampleController {

    @GetMapping("/hello")
    public String greet() {
        return "Hello";
    }
}
