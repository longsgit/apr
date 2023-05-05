package com.example.miscapp.consumer;


import com.example.miscapp.model.NumberPayload;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.function.Consumer;

@Configuration
public class NumberConsumerConfiguration {

    @Bean
    public Consumer<List<NumberPayload>> squaredNumberConsumer() {
        return lst -> {
            lst.forEach(System.out::println);
        };
    }

    @Bean
    public Consumer<KStream<String, String>> squaredNumberConsumer2() {
        return stream -> {
            stream
                    .mapValues(e -> Integer.parseInt(e) * Integer.parseInt(e))
                    .foreach((k, v) -> System.out.println(v));
        };
    }

}