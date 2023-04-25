package com.herbalife.wordconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

//@Component
public class WordConsumer {

    @KafkaListener(topics = "word-topic", groupId = "word-consumer-group-console3")
    public void printWordToConsole(String word) {
        System.out.println("***** (Console) Received %s".formatted(word));
    }

    @KafkaListener(topics = "word-topic", groupId = "word-consumer-group-db3")
    public void sendWordToDB(String word) {
        System.out.println("***** (DB) Received %s".formatted(word));
    }

    @KafkaListener(topics = "word-topic", groupId = "word-consumer-group-email3")
    public void emailWord(String word) {
        System.out.println("***** (Email) Received %s".formatted(word));
    }
}
