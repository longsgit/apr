package com.herbalife.examples;

import java.util.function.Predicate;

public class FunctionalInterfacesPredicateExample {
    public static void main(String[] args) {
        //filter(...)

        //java.util.function
        //Predicate, Function, Supplier, Consumer

        //Predicate accepts data of any Type and always returns a boolean
        Predicate<Integer> isEven = num -> num % 2 == 0;
        Predicate<Integer> isGt10 = num -> num > 10;
        Predicate<Integer> evenAndGt10Check = isEven.and(isGt10);

        System.out.println(evenAndGt10Check.test(12));
        System.out.println(evenAndGt10Check.test(13));
        System.out.println(evenAndGt10Check.test(14));


        boolean result = isEven
                .and(isGt10)
                .test(13);

        boolean result2 = isEven
                .or(isGt10)
                .test(12);


        System.out.println(isEven.test(10));
        System.out.println(isEven.test(11));
        System.out.println(isEven.negate().test(3));


        Predicate<String> lengthPredicateGt10 = value -> value.length() > 10;
        System.out.println(lengthPredicateGt10.test("jksfhgjshg"));
        System.out.println(lengthPredicateGt10.test("qwerty"));

    }
}
