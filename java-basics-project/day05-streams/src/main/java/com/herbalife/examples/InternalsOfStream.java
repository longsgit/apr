package com.herbalife.examples;

import java.util.Arrays;
import java.util.List;

public class InternalsOfStream {
    public static void main(String[] args) {
        //Streams process one item at a time; it takes the item through all the stages
        //Streams in Java are lazily evaluated
        //They are evaluated only when the terminal operation is met
        //ie., get() or find() or forEach()
        List<Integer> numbers = Arrays.asList(101, 120, 330, 408, 519, 876);
        numbers
                .stream()
                .filter(e -> {
                    System.out.println("******* filter " + e);
                    return e % 2 == 0;
                })
                .map(e -> {
                    System.out.println("******* map " + e);
                    return e * e;
                });
//                .findFirst()
//                .get();
//                .forEach(System.out::println);
    }
}
