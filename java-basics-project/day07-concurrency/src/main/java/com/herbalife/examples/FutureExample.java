package com.herbalife.examples;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);

        Future<Integer> future = es.submit(() -> {
            int count = 0;
            while(count < 5) {
                System.out.println("Computing random number ...");
                MyThreadUtil.sleep(1);
                count++;
            }
            return (int)(Math.random() * 100);
        });
        while(!future.isDone()) {
            System.out.println("Waiting for result");
            MyThreadUtil.sleep(1);
        }
        System.out.println(future.get()); //Blocking call
        System.out.println("End of main");
        es.shutdownNow();
    }
}
