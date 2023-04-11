package com.herbalife.examples;

import java.util.*;
import java.util.function.Consumer;

public class ForEachOnCollections {
    public static void main(String[] args) {
        int[] numbersArr = {1, 2, 3, 4, 5};
        for (int i = 0; i < numbersArr.length; i += 2) {
            System.out.println(numbersArr[i]);
        }
        Arrays
                .asList(numbersArr)
                .stream()
                .forEach(num -> System.out.println(num));


        List<Integer> numbers = new ArrayList<>();
        numbers.add(100);
        numbers.add(200);
        numbers.add(300);

        Consumer<Integer> print = num -> System.out.println(num);
        numbers.forEach(print);

        numbers.forEach(num -> System.out.println(num));

        Set<String> languages = new HashSet<>();
        languages.add("Golang");
        languages.add("Java");
        languages.forEach(e -> System.out.println(e));

        Map<Integer, String> romanNumerals = new HashMap<>();
        romanNumerals.put(1, "I");
        romanNumerals.put(2, "II");
        romanNumerals.put(3, "III");
        romanNumerals.forEach((key, value) -> System.out.println(key + ": " + value));

        //OLD STYLE
//        for (int i = 0; i < numbers.size(); i++) {
//            System.out.println(numbers.get(i));
//        }
    }
}
