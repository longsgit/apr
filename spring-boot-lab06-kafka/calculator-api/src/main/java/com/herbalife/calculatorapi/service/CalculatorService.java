package com.herbalife.calculatorapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${calculator.topics.square}")
    private String squareTopic;

    @Value("${calculator.topics.increment}")
    private String incrementTopic;

    public void publishSquare(int num) {
        kafkaTemplate.send(squareTopic, num + "");
    }

    public void publishIncrement(int num) {
        kafkaTemplate.send(incrementTopic, num + "");
    }
}
