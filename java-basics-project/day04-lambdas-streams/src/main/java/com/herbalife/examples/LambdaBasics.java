package com.herbalife.examples;

public class LambdaBasics {
    public static void main(String[] args) {
        Worker coder = () -> System.out.println("Writing code with Copilot");
        coder.work();

        Worker guitarist = () -> {
            System.out.println("Playing the guitar");
        };
        guitarist.work();

        Formatter toCaps = data -> data.toUpperCase(); //Type of data is inferred
        System.out.println(toCaps.format("hello"));

        Formatter toLower = (String data) -> data.toLowerCase();
        System.out.println(toLower.format("Sam"));

        Formatter toCamelCase = (String data) -> {
            System.out.println("Formatting to camelCase");
            return data.toLowerCase();
        };
        System.out.println(toCamelCase.format("hello there"));


    }
}

@FunctionalInterface
interface Formatter {
    String format(String data);
    //void dummy();
}

@FunctionalInterface
interface Worker {
    void work();
}

interface Calc {
    int add(int a, int b);
    int subtract(int a, int b);
}