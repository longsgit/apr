package com.herbalife.labs.lab06;

public class Lab06 {
    public static void main(String[] args) {
//        Calculator calculator = new Calculator();
//        calculator.add(10, 5);
//        calculator.subtract(10, 5);
//        calculator.multiply(10, 5);

        Calc add = (a, b) -> a + b;
        Calc subtract = (a, b) -> a - b;

        operate(add);
        operate(subtract);
        operate((a, b) -> a * b);
        operate((a, b) -> (a * a) + (b * b) + (2 * a * b));
    }

    static void operate(Calc calc) {
        System.out.println(calc.compute(10, 5));
    }
}

@FunctionalInterface
interface Calc {
    int compute(int a, int b);
}
