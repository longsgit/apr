package com.herbalife.wordconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class WordConsumer {

    @KafkaListener(topics = "word-topic", groupId = "word-consumer-group-dev")
    public void receiveWord(String word) {
        System.out.println("***** Received %s".formatted(word));
    }
}
