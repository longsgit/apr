package com.herbalife.exceptionhandlingconsumerapp;

import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;

@Component
public class WordConsumer {
    //control retry attempts; after that move on to the next message
    //you don't want to lose the message

    //After the number of attempts is exhausted, consumer automatically publishes the message to a DLT
    @RetryableTopic(attempts = "4", backoff = @Backoff(delay = 2000, multiplier = 2.0))
    @KafkaListener(topics = "word-topic", groupId = "ex-handling-consumer-local")
    public void processWord(String word) {
        System.out.println("***Received " + word);
        String[] letters = word.split("");
        //Let me write something stupid, to generate error
        System.out.println("Last letter is " + letters[word.length()]);
    }

    @DltHandler
    public void deadLetterTopicCallback(String word) {
        System.out.println("======== %s published to DLT".formatted(word));
    }
}
