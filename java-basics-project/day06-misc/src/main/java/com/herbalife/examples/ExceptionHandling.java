package com.herbalife.examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExceptionHandling {
    public static void main(String[] args) throws Exception {
        try {
            Files.readAllLines(Paths.get("./cities.csv"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            System.out.println("End");
        }
        try {
            int i = 10;
            int j = 0;
            divide(i, j);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        divide(12, 2);
    }

    static void divide(int num, int den) throws Exception {
        if (den == 0) {
            throw new Exception("You are trying to divide by zero");
            //throw new RuntimeException("You are trying to divide by zero");
        }
        System.out.println(num / den);
    }
}

//java.lang.Exception contains the info about the error occurred
//You write code to handle Exception
//try, catch, finally, throw, throws(!!!)

//Checked and Unchecked Exception
//Checked exceptions are those that inherit java.lang.Exception class
//Unchecked exceptions are those that inherit java.lang.RuntimeException class
