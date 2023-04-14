package com.herbalife.examples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsStrategy {
    public static void main(String[] args) {
        //number of cores
        //CPU or IO intensive operations
        int numberOfCores = Runtime.getRuntime().availableProcessors();
        System.out.println(numberOfCores);

        //General safe rule is numberOfThreads = numberOfCores - 1;
        int numberOfThreads = numberOfCores - 1;
        ExecutorService es = Executors.newFixedThreadPool(numberOfThreads);

        //numberOfThreads = numberOfCores / (1 - BlockingFactor)
        //Blocking Factor 0 < 1
        //If CPU intensive Blocking Factor < 0.4
        //If IO intensive Block Factory is almost close to 1

        int numberOfThreadsForIOOperations = (int)(numberOfCores / (1 - 0.9));
        System.out.println(numberOfThreadsForIOOperations);


    }
}
