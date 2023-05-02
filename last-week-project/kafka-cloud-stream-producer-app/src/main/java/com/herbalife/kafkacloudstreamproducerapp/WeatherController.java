package com.herbalife.kafkacloudstreamproducerapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    private StreamBridge streamBridge;

    @PostMapping("/weather/city/{city}")
    public String getTemperatureOf(@PathVariable String city) {
        streamBridge.send("weather-out-0", city);
        return "%s is posted to kafka".formatted(city);
    }
}
