package com.herbalife.producerapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping("/temperature/{country}/{city}")
    public String getTemperature(@PathVariable String country, @PathVariable String city) {
        kafkaTemplate.send("weather-topic", country, city);//key,value
        return "%s posted to kafka".formatted(city);
    }

//    @GetMapping("/temperature/{city}")
//    public String getTemperature(@PathVariable String city) {
//        kafkaTemplate.send("weather-topic", city);
//        return "%s posted to kafka".formatted(city);
//    }
}
