package com.herbalife.labs.lab10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lab10ApproachIII {
    static List<Item> items = Arrays.asList(new Item("Nike", 20.45), new Item("Adidas", 31.45), new Item("Reebok", 29.25), new Item("Puma", 25.15), new Item("Fila", 15.15));

    public static void main(String[] args) {

        Item costliestShoe = items
                .stream()
                .collect(Collectors.maxBy(Comparator.comparing(item -> item.getPrice())))
                .get();
        System.out.println(costliestShoe);

        Item cheapestShoe = items
                .stream()
                .collect(Collectors.minBy(Comparator.comparing(Item::getPrice)))
                .get();
        System.out.println(cheapestShoe);


        concatNamesOfShoes();
    }

    private static void concatNamesOfShoes() {
        String shoesInCsv = items
                .stream()
                .map(it -> it.getName())
                .collect(Collectors.joining(", "));
        System.out.println(shoesInCsv);
    }


}
