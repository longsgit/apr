package com.herbalife.examples;

public class LambdaExpressions {
    public static void main(String[] args) {
        Greetings greetingsOldStyle = new GreetingsImpl();
        System.out.println(greetingsOldStyle.hi("Ram"));

        Greetings myGreetings = new MyGreetings();
        System.out.println(myGreetings.hi("Mary"));

        //Anonymous inner class
        //creating a new class without any name +  implements Greetings + creating an object of it
        Greetings greetingsIntermediateStyle = new Greetings() {
            @Override
            public String hi(String name) {
                return "Hey " + name;
            }
        };
        System.out.println(greetingsIntermediateStyle.hi("Sam"));

        Greetings greetingsModernStyle = name -> "Wassup " + name;
        System.out.println(greetingsModernStyle.hi("Sam"));
        System.out.println(greetingsModernStyle.getClass().getName());
    }
}

interface Greetings {
    String hi(String name);
}
class GreetingsImpl implements Greetings {
    public String hi(String name) {
        return "Hi " + name;
    }
}
class MyGreetings implements Greetings {
    @Override
    public String hi(String name) {
        return "Hello " + name;
    }
}