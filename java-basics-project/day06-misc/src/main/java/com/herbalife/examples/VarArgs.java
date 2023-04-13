package com.herbalife.examples;

import java.util.Arrays;

public class VarArgs {
    public static void main(String[] args) {
        System.out.println(add(10, 20, 30));
        System.out.println(add(10, 200, 3004, 500));
    }

    static int add(int... numbers) {
        return Arrays.stream(numbers).sum();
    }
}
