package com.herbalife.exceptionhandlingconsumerapp;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class DltConsumer {

    @KafkaListener(topics = "word-topic-dlt", groupId = "dlt-consumer-local")
    public void processWord(String word) {
        System.out.println("***Received " + word + " from DLT");
        String[] letters = word.split("");
        //Let me write something stupid, to generate error
        System.out.println("Last letter is " + letters[word.length() - 1]);
    }
}
