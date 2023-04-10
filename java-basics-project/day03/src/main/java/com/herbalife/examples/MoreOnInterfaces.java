package com.herbalife.examples;

import java.time.Instant;

public class MoreOnInterfaces {
    public static void main(String[] args) {
        Printer.printTime();
        Printer printer = new PrinterImpl();
        printer.print("some data");
        System.out.println(Printer.COUNT);
        //Printer.COUNT = 10;
    }
}
interface Printer {
    //variables in an interface are implicitly public, static and final
    int COUNT = 1;
    void print(String data);
    default void printToConsole(String data) {
        System.out.println(data);
    }
    static void printTime() {
        System.out.println(Instant.now());
    }
}

class PrinterImpl implements Printer {
    public void print(String data) {
        printToConsole(data);
    }

//    @Override
//    public void printToConsole(String data) {
//        //You can override default methods too
//    }
}
