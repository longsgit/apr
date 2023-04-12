package com.herbalife.labs.lab10;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lab10ApproachI {
    static List<Item> items = Arrays.asList(new Item("Nike", 20.45), new Item("Adidas", 31.45), new Item("Reebok", 29.25), new Item("Puma", 25.15), new Item("Fila", 15.15));

    public static void main(String[] args) {
        printCostliestShoe();
        printCheapestShoe();
        concatNamesOfShoes();
    }

    private static void concatNamesOfShoes() {
        String shoesInCsv = items
                .stream()
                .map(it -> it.getName())
                .collect(Collectors.joining(", "));
        System.out.println(shoesInCsv);
    }

    private static void printCostliestShoe() {
        Item costliestItem = items
                .stream()
                .reduce((prev, next) -> prev.getPrice() > next.getPrice() ? prev : next)
                .get();
        System.out.println(costliestItem);
    }

    private static void printCheapestShoe() {
        Item cheapestItm = items
                .stream()
                .reduce((prev, next) -> prev.getPrice() < next.getPrice() ? prev : next)
                .get();
        System.out.println(cheapestItm);
    }

}
