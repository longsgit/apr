package com.herbalife.consumerapp;

import com.herbalife.model.Stock;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class StockConsumer {

    @KafkaListener(topics = "stock-topic", groupId = "stock-consumer-local")
    public void computeCurrentMarketPrice(Stock stock) {
        System.out.println("***Received " + stock.getSymbol() + ", " + stock.getExchange());
    }
}
