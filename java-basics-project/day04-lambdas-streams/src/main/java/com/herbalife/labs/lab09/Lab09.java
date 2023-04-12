package com.herbalife.labs.lab09;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lab09 {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(new Item("Nike", 20.45), new Item("Adidas", 31.45), new Item("Reebok", 29.25), new Item("Puma", 25.15), new Item("Fila", 15.15));
        items
                .stream()
                .map(it -> String.format("%s: %s", it.getName(), it.getPrice()))
                .forEach(it -> System.out.println(it));

        items
                .stream()
                .filter(it -> it.getPrice() > 20)
                .map(it -> it.getName())
                .forEach(it -> System.out.println(it));

        List<String> names = items
                .stream()
                .map(it -> it.getName())
                .collect(Collectors.toList());
        names.forEach(it -> System.out.println(it));
    }
}
