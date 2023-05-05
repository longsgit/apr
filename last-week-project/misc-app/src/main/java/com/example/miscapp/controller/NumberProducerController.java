package com.example.miscapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.math.BigInteger;
import java.time.Duration;
import java.util.List;

@RestController
public class NumberProducerController {

    @Autowired
    private StreamBridge streamBridge;

    @PostMapping("/numbers")
    public void postNumbers(@RequestBody List<Long> numbers) {
        numbers.forEach(num -> streamBridge.send("number-out-0", num + ""));
    }
}
