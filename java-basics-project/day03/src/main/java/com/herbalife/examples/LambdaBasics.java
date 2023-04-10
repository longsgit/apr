package com.herbalife.examples;

public class LambdaBasics {
    public static void main(String[] args) {
        //You can use lambdas only on interfaces with ONE abstract method
        //an interface with JUST ONE ABSTRACT METHOD is called FunctionalInterface
        Player cricketer = game -> System.out.println("Playing " + game);
        cricketer.play("T20");

        Player footballer = game -> {
            System.out.println("Playing " + game);
            System.out.println("I am good at it");
        };
        footballer.play("Football");

        Player testPlayer = (String game) -> System.out.println("Playing " + game);
        Programmer javaProgrammer = (language, ide) -> System.out.println("Writing code in " + language + " using " + ide);
        Programmer golangProgrammer = (String language, String ide) -> System.out.println("Writing code in " + language + " using " + ide);

        MyPrinter hpPrinter = data -> "Printing " + data + " using HP printer"; //return keyword is not required
        System.out.println(hpPrinter.print("lorem ipsum..."));

        MyPrinter samsungPrinter = data -> {
            System.out.println("Turning Samsung on");
            System.out.println("Check for paper alignment");
            return "Printing " + data + " using Samsung printer";
        };

    }
}

@FunctionalInterface
interface MyPrinter {
    String print(String data);
}

@FunctionalInterface
interface Programmer {
    void writeCodeIn(String language, String ide);
}

@FunctionalInterface //Optional
interface Player {
    void play(String game);
    //void sleep();
    default void eat() {}
    static void workOut() {}
    long SALARY_CAP = 7898798;
}
