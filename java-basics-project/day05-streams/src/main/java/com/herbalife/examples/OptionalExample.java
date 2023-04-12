package com.herbalife.examples;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalExample {
    static Map<Integer, String> romanNumerals = new HashMap<>();

    static {
        romanNumerals.put(1, "I");
        romanNumerals.put(2, "II");
        romanNumerals.put(3, "III");
    }

    public static void main(String[] args) {
        String value = getRomanNumberOf(2);
        System.out.println(value + ", " + value.length());

        String value4 = getRomanNumberOf(4);
        if (value4 != null) {
            System.out.println(value4 + ", " + value4.length());
        }

        Optional<String> optionalValue5 = getRomanNumeralOf(5);
        if (optionalValue5.isPresent()) {
            System.out.println(optionalValue5.get());
        } else {
            System.out.println("Value for 5 is not found");
        }

        System.out.println(getRomanNumeral(1));
        System.out.println(getRomanNumeral(11));

    }

    static String getRomanNumeral(int num) {
        return Optional
                .ofNullable(romanNumerals.get(num))
                .orElse(num + " is not found");
    }

    static Optional<String> getRomanNumeralOf(int num) {
        Optional<String> optValue = Optional.empty();
        if (romanNumerals.get(num) != null) {
            optValue = Optional.of(romanNumerals.get(num));
        }
        return optValue;
    }

    //It's not a good practice to return null values from a method
    static String getRomanNumberOf(int num) {
        return romanNumerals.get(num);
    }
}
