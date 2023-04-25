package com.herbalife.calculatordbconsumer.consumer;

import com.herbalife.calculatordbconsumer.service.CalculatorOperationDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CalculatorNumberConsumer {

    @Autowired
    private CalculatorOperationDbService calculatorOperationDbService;

    @KafkaListener(topics = "${calculator.topics.square}")
    public void computeSquare(String num) {
        int number = Integer.parseInt(num);
        calculatorOperationDbService.create(number, "Square");
        System.out.println("Saved square operation of %d to DB".formatted(number));
    }

    @KafkaListener(topics = "${calculator.topics.increment}")
    public void computeIncrement(String num) {
        int number = Integer.parseInt(num);
        calculatorOperationDbService.create(number, "Increment");
        System.out.println("Saved increment operation of %d to DB".formatted(number));
    }
}