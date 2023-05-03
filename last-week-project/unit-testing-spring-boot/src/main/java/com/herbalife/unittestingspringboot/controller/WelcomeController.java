package com.herbalife.unittestingspringboot.controller;

import com.herbalife.unittestingspringboot.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WelcomeController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/hello")
    public String hello() {
        return "Hi!";
    }

    @GetMapping("/hello/{name}")
    public String hi(@PathVariable String name) {
        return "Hello " + name;
    }

    @PostMapping("/training")
    public HttpEntity<Void> registerForTraining(@RequestParam String email) {
        registrationService.register(email);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
