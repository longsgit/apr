package com.herbalife.examples;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;

public class CommonOperationsOnStreams {
    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Python", "C#", "JavaScript", "Scala");

        //Print the languages beginning with J
        languages
                .stream()
                .filter(e -> e.startsWith("J")) //filter is a method that takes a Predicate as argument
                .forEach(e -> System.out.println(e));

        //Print the languages with length > 3
        languages
                .stream()
                .filter(e -> e.length() > 3)
                .forEach(e -> System.out.println(e));

        //Print the languages with length > 3 and starting with J
        languages
                .stream()
                .filter(e -> e.startsWith("J"))
                .filter(e -> e.length() > 3)
                .forEach(e -> System.out.println(e));

        //Print the languages in UpperCase
        languages
                .stream()
                .map(e -> e.toUpperCase()) //map is a method that takes a Function as argument; Transforms every item and returns a new collection (stream)
                .forEach(e -> System.out.println(e));

        //Print the languages with length > 3 and starting with J in UPPERCASE
        languages
                .stream()
                .filter(lang -> lang.startsWith("J"))
                .filter(lang -> lang.length() > 3)
                .map(lang -> lang.toUpperCase())
                .forEach(lang -> System.out.println(lang));

    }
}
