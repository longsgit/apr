package com.herbalife.springbootrestapi;

import org.springframework.web.bind.annotation.*;

@RestController
public class WelcomeController {

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
