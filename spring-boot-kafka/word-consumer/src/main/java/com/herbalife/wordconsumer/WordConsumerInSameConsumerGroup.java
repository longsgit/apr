package com.herbalife.wordconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class WordConsumerInSameConsumerGroup {

    @KafkaListener(topics = "word-topic", groupId = "word-consumer-group-same")
    public void process1(String word) {
        System.out.println("***** (Process1) Received %s".formatted(word));
    }

    @KafkaListener(topics = "word-topic", groupId = "word-consumer-group-same")
    public void process2(String word) {
        System.out.println("***** (Process2) Received %s".formatted(word));
    }

    @KafkaListener(topics = "word-topic", groupId = "word-consumer-group-same")
    public void process3(String word) {
        System.out.println("***** (Process3) Received %s".formatted(word));
    }
}
