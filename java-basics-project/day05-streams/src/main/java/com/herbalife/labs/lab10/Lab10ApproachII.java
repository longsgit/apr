package com.herbalife.labs.lab10;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Lab10ApproachII {
    static List<Item> items = Arrays.asList(new Item("Nike", 20.45), new Item("Adidas", 31.45), new Item("Reebok", 29.25), new Item("Puma", 25.15), new Item("Fila", 15.15));

    public static void main(String[] args) {
        printShoe((prevShoe, nextShoe) -> prevShoe.getPrice() > nextShoe.getPrice() ? prevShoe : nextShoe);
        printShoe((prevShoe, nextShoe) -> prevShoe.getPrice() < nextShoe.getPrice() ? prevShoe : nextShoe);
        concatNamesOfShoes();
    }

    private static void concatNamesOfShoes() {
        String shoesInCsv = items
                .stream()
                .map(it -> it.getName())
                .collect(Collectors.joining(", "));
        System.out.println(shoesInCsv);
    }

    private static void printShoe(BinaryOperator<Item> comparisonFunction) {
        Item item = items
                .stream()
                .reduce(comparisonFunction)
                .get();
        System.out.println(item);
    }

}
