package com.herbalife.examples;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionalInterfacesFunction {
    public static void main(String[] args) {
        //Is a FunctionalInterface that takes data of ANY type and returns data of ANY type
        Function<Integer, Integer> incrementor = num -> num + 1;
        System.out.println(incrementor.apply(10));
        System.out.println(incrementor.apply(1000));

        Function<String, Integer> lengthFunction = data -> data.length();
        System.out.println(lengthFunction.apply("hello"));

        //take a number, decrement it by 1, and return the square
        Function<Integer, Integer> decrementor = num -> num - 1;
        Function<Integer, Integer> squareFunction = num -> num * num;
        int result = decrementor
                .andThen(squareFunction)
                .apply(10);
        System.out.println(result);
        BiFunction<String, String, String> concatFunction = (value1, value2) -> value1 + " " + value2;
        System.out.println(concatFunction.apply("Sam", "Thomas"));
    }
}
//class MyFunction implements Function<T, R> {
//    @Override
//    public R apply(T t) {
//        return null;
//    }
//
//    @Override
//    public <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
//        return Function.super.andThen(after);
//    }
//}

