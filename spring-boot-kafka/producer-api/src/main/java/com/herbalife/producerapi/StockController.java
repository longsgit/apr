package com.herbalife.producerapi;

import com.herbalife.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @PostMapping("/symbol/{symbol}/exchange/{exchange}")
    public String postStockSymbol(@PathVariable String symbol, @PathVariable String exchange) {
        Stock stock = new Stock();
        stock.setSymbol(symbol);
        stock.setExchange(exchange);
        kafkaTemplate.send("stock-topic", exchange, stock);
        return "Posted %s to kafka".formatted(symbol);
    }
}
