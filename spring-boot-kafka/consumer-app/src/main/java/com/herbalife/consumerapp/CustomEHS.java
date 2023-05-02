package com.herbalife.consumerapp;

import com.herbalife.model.Stock;
import org.apache.kafka.common.header.Headers;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.stereotype.Component;

@Component
public class CustomEHS extends ErrorHandlingDeserializer<Stock> {
    @Override
    public Stock deserialize(String topic, Headers headers, byte[] data) {
        System.out.println(new String(data));
        Stock stock = new Stock();
        stock.setExchange("NSE");
        stock.setSymbol("IBM");
        return stock;
    }
}
