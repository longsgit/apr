package com.herbalife.examples;

import java.util.ArrayList;
import java.util.List;

public class GenericsGimmick {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        List<String> languages = new ArrayList<>();
        List<Boolean> tokens = new ArrayList<>();


        //Compiler erases all the generic code into a non-generic code
        //So List<Integer> is same as List<String> and List<Boolean>
        //JVM doesn't know anything about generics
        //So, Generics in Java is a compile-time gimmick to make developers write some harmless code

        System.out.println(numbers.getClass().getName()); //getType()
        System.out.println(languages.getClass().getName());
        System.out.println(tokens.getClass().getName());
        Object numbers2 =  new ArrayList<Integer>();

//        if(numbers2 instanceof List<Integer>) {
//            System.out.println("Numbers");
//        } else if (numbers2 instanceof List<String>) {
//
//        } else if(numbers2 instanceof List<Boolean>) {
//
//        }
    }
}
