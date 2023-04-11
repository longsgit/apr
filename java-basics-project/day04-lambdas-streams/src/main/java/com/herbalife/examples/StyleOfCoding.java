package com.herbalife.examples;

import java.util.Arrays;
import java.util.List;

public class StyleOfCoding {
    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Python", "C#", "JavaScript", "Scala");
        //Print all the languages that begin with J

        traditionalStyle(languages);
        declarativeStyle(languages);
    }

    private static void declarativeStyle(List<String> languages) {
        //Declarative style of programming
        //Write code and tell what to do
        //Data is not scattered at all (Immutable style)
        //Easy to parallelize
        //Readability is really cool and seamless
        languages
                .stream()
                //.parallel() //add a switch to make it run parallely
                .filter(lang -> lang.startsWith("J"))
                .forEach(lang -> System.out.println(lang));
    }

    private static void traditionalStyle(List<String> languages) {
        //Write code and tell what to do and also how to do
        //start creating variables and storing information
        //Difficult to parallelize
        //Imperative style of programming
        for (int i = 0; i < languages.size(); i++) {
            String language = languages.get(i);
            if (language.startsWith("J")) {
                System.out.println(language);
            }
        }
    }
}
