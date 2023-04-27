package com.herbalife.consumerapp;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

//@Component
public class WeatherConsumer {

    @KafkaListener(topics = "weather-topic", groupId = "weather-consumer-group-local")
    public void processTemperature(ConsumerRecord record) {
        long timestamp = record.timestamp();
        int partition = record.partition();
        String country = record.key().toString();
        String city = record.value().toString();
        double temperature = Math.random() * 100;
        System.out.println("*************Processing %s from partition %d (%s) at %s".formatted(city, partition, country, timestamp));
        System.out.println("Temperature of %s is %s".formatted(city, temperature));
    }

//    @KafkaListener(topics = "weather-topic", groupId = "weather-consumer-group-local")
//    public void processTemperature(String city) {
//        double temperature = Math.random() * 100;
//        System.out.println("Temperature of %s is %s".formatted(city, temperature));
//    }
}
