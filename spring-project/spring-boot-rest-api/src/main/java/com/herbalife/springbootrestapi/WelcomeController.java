package com.herbalife.springbootrestapi;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class WelcomeController {

    @GetMapping("/topics")
    public List<String> getTopics() {
        return Arrays.asList("Spring boot", "Rest", "JPA");
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/hello/{name}")
    public String greet(@PathVariable("name") String name) {
        return "Hi " + name;
    }

    ///bye?name=Ram
    @PostMapping("/bye")
    public String bye(@RequestParam("name") String name) {
        return "Bye bye " + name;
    }
}
