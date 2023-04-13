package com.herbalife.examples;

public class MoreOnStrings {
    public static void main(String[] args) {
        String message = "Hello! \n";
        message += "How are you? \n";
        message += "What's going on?";
        System.out.println(message);
        //Multi-line string
        //Text blocks
        String paragraph = """ 
Hello!
How are you?
What's going on?
                """;
        System.out.println(paragraph.stripLeading().stripTrailing());
        String name = "Sam";
        System.out.println(String.format("Hello %s", name));
        System.out.println("Hi %s. You are %d years old".formatted(name, 12));
    }
}
