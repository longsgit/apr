package com.herbalife.examples;

public class EnumExample {
    public static void main(String[] args) {
        Month monthOfBirth = Month.FEB;
        Month monthOfWedding = Month.MAR;

        System.out.println(Month.JAN.ordinal());
        System.out.println(Month.MAR.ordinal());

        System.out.println(Numbers.ONE);
        System.out.println(Numbers.TWO);
        System.out.println(Numbers.THREE);
    }
}
enum Numbers {
    ONE(1), TWO(2), THREE(3);


    Numbers(int value) {
        this.value = value;
    }
    private int value;

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
enum Month {
    JAN, FEB, MAR
}
