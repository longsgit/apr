package com.herbalife.calculatorresultconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CalculatorNumberConsumer {

    @KafkaListener(topics = "${calculator.topics.square}")
    public void computeSquare(String num) {
        int number = Integer.parseInt(num);
        System.out.println("Square of %d is %d".formatted(number, (number * number)));
    }

    @KafkaListener(topics = "${calculator.topics.increment}")
    public void computeIncrement(String num) {
        int number = Integer.parseInt(num);
        System.out.println("Incrementing %d to %d".formatted(number, (number + 1)));
    }
}
