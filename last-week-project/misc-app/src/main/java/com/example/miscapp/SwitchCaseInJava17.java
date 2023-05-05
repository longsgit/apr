package com.example.miscapp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwitchCaseInJava17 {
    public static void main(String[] args) {
        int num = 10;
        String message = findEvenOrOdd(num);

        String operationType = "I";
        switch (operationType) {
            case "I" -> System.out.println("Insert");
            case "U", "D" -> System.out.println("Modify");
        }
        ;

        //String output = "Even" if num % 2 == 0 else "Odd";

        //Map<String, List<String>> countryCitiesMap = new HashMap<>();
        var countryCitiesMap = new HashMap<>();
        //countryCitiesMap = "hello"; //You cannot change the type of the value unlike Javascript
        var para = """
                """;

//        String message;
//        switch(num % 2) {
//            case 0:
//                message = "Even";
//                break;
//            case 1:
//                message = "Odd";
//                break;
//            default:
//                message = "WTH is this number";
//        }
    }

    private static String findEvenOrOdd(int num) {
        return switch (num % 2) {
            case 0 -> "Even";
            case 1 -> "Odd";
            default -> "WTH";
        };
    }
}
