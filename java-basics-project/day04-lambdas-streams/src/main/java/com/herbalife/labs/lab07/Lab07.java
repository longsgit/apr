package com.herbalife.labs.lab07;

import java.util.function.BiFunction;


public class Lab07 {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        BiFunction<Integer, Integer, Integer> subtract = (a, b) -> a - b;

        operate(add);
        operate(subtract);
        operate((a, b) -> a * b);
        operate((a, b) -> (a * a) + (b * b) + (2 * a * b));
    }

    static void operate(BiFunction<Integer, Integer, Integer> biFunction) {
        System.out.println(biFunction.apply(10, 5));
    }
}
