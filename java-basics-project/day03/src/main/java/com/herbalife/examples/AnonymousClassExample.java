package com.herbalife.examples;

public class AnonymousClassExample {
    public static void main(String[] args) {
        //Inline implementation of Greetings interface
        Greetings greetings = new Greetings() {
            @Override
            public String hi(String name) {
                bye();
                return "Confused " + name;
            }
            public void bye() {} //pretty much useless
        };
        greetings.hi("John");
    }
}
