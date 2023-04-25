package com.herbalife.wordproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class WordProducerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WordProducerApplication.class, args);
    }

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Override
    public void run(String... args) throws Exception {
        String topic = "word-topic";
        kafkaTemplate.send(topic, "hot");
    }
}
