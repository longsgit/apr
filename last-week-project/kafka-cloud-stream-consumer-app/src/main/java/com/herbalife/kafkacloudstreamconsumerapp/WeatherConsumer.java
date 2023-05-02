package com.herbalife.kafkacloudstreamconsumerapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class WeatherConsumer {

    @Bean
    public Consumer<String> consumerWeatherInformation() {
        return (city) -> {
            System.out.println("*****RECEIVED " + city);
        };
    }
}
