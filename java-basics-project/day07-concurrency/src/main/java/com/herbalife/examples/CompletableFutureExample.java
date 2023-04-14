package com.herbalife.examples;

import java.util.concurrent.*;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        //Promises in JavaScript
        //It returns a value in the future; It calls the callback by supplying the value
        //It does not block other operations
        CompletableFuture
                .supplyAsync(() -> {
                    int count = 0;
                    while (count < 5) {
                        System.out.println("Computing random number ....");
                        MyThreadUtil.sleep(1);
                        count++;
                    }
                    return (int) (Math.random() * 100);
                }, es)
                .thenAccept(randomNumber -> System.out.println(randomNumber));

        System.out.println("End of main");
        MyThreadUtil.sleep(100);
    }
}
