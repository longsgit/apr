package com.herbalife.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntroductionToStreams {
    public static void main(String[] args) {
        //introduced in Java 1.8
        //Stream in a snapshot of the underlying collection
        //It is used to process collections
        //Process the elements in a collection sequentially
        //Streams cannot be reused. Once it is created and operated upon, you can use it again
        //You can only read items using streams; You cannot modify the underlying collection using streams

        List<String> languages = Arrays.asList("Java", "Python", "C#", "JavaScript", "Scala");

        Stream<String> languagesStream = languages.stream();
        languagesStream
                .forEach(e -> System.out.println(e));

        //ERROR
//        languagesStream
//                .forEach(e -> System.out.println(e));
        languages
                .stream()
                .forEach(e -> System.out.println(e));

    }
}
