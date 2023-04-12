package com.herbalife.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReferenceOperatorExample {
    public static void main(String[] args) {
        //:: is a method reference operator; similar to scope operator in C++

        Function<Integer, Integer> squareFunction = num -> num * num;
        System.out.println(squareFunction.apply(12));

        Calculator calc = new Calculator();
        Function<Integer, Integer> squareFunction2 = calc::computeSquare; //function pointer
        System.out.println(squareFunction2.apply(10));

//        BiFunction<Integer, Integer, Integer> aPlusBWholeSquared = (a, b) -> {
//            int aSq = a * a;
//            int bSq = b * b;
//            int twoAB = 2 * a * b;
//            return aSq + bSq + twoAB;
//        };
        BiFunction<Integer, Integer, Integer> aPlusBWholeSquared = MethodReferenceOperatorExample::findAPlusBWholeSquared;
        System.out.println(aPlusBWholeSquared.apply(10, 20));

        List<Integer> numbers = Arrays.asList(100, 200, 300);
        numbers.forEach(num -> System.out.println(num));
        numbers.forEach(System.out::println);

    }

    static int findAPlusBWholeSquared(int a, int b) {
        int aSq = a * a;
        int bSq = b * b;
        int twoAB = 2 * a * b;
        return aSq + bSq + twoAB;
    }

}

class Calculator {
    public int computeSquare(int num) {
        return num * num;
    }
}
