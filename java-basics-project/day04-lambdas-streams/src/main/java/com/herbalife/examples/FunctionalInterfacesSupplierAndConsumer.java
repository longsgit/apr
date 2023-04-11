package com.herbalife.examples;

import java.time.Instant;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FunctionalInterfacesSupplierAndConsumer {
    public static void main(String[] args) {
        //Supplier is a FI that supplies you with data
        Supplier<Integer> randomSupplier = () -> (int)(Math.random() * 100);
        System.out.println(randomSupplier.get());
        System.out.println(randomSupplier.get());

        Supplier<String> now = () -> Instant.now().toString();
        System.out.println(now.get());

        //Consumer is a FI that consumes the data you provide
        Consumer<String> printToConsole = data -> System.out.println(data);
        printToConsole.accept("Hello");
        printToConsole.accept("Hi");

        Consumer<Message> logger = message -> {
            System.out.println("Writing to log file " + message);
        };
        logger.accept(new Message());
        logger.accept(new Message());
    }
}

class Message {}