package com.herbalife.examples;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MoreMethodsOnStreams {
    public static void main(String[] args) {
        //filter, map
        List<Integer> numbers = Arrays.asList(100, 200, 300, 400, 500, 600, 700);

        int sumOfAllNumbers = numbers
                .stream()
                .mapToInt(e -> e)
                .sum();

        //sum of all numbers
        int sum = numbers
                .stream()
                .reduce(0, (total, current) -> total + current);
        System.out.println(sum);

        //sum of squares of all numbers
        int sumOfSquares = numbers
                .stream()
                .map(it -> it * it)
                .reduce(0, (total, current) -> total + current);
        System.out.println(sumOfSquares);

        //sum of squares of all numbers divisible by 3
        int sumOfSquaresOfNumbersDivBy3 = numbers
                .stream()
                .filter(it -> it % 3 == 0)
                .map(it -> it * it)
                .reduce(0, (total, current) -> total + current);
        System.out.println(sumOfSquaresOfNumbersDivBy3);

        List<String> lst = Arrays.asList("a", "a", "b", "b", "c", "c", "c");
        Map<String, Long> countMap = lst
                .stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(countMap); //{a=2, b=2, c=3}
        Map<String, Long> countMap1 = lst
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(countMap1);
    }
}
