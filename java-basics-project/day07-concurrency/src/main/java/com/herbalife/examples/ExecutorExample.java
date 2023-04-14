package com.herbalife.examples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);

        es.submit(() -> {
            while(true) {
                System.out.println("Coding in Java in " + MyThreadUtil.name());
                MyThreadUtil.sleep(1);
            }
        });

        es.submit(() -> {
            while(true) {
                System.out.println("Watching YT in " + MyThreadUtil.name());
                MyThreadUtil.sleep(3);
            }
        });

    }
}
