package com.herbalife.examples;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ParallelStreams {
    public static void main(String[] args) {
        //By default parallel streams create number of cores - 1 threads and execute the collection
        //It uses a ForkJoinPool internally
        //You can override the thread count by creating a custom forkjoinpool and submitting the parallel stream to it

        ForkJoinPool fjp = new ForkJoinPool(80);

        LongStream numbers = LongStream.range(1, 10000000L);

        fjp.submit(() -> {
            numbers
                    .parallel()
                    .filter(e -> {
                        System.out.println("Filter " + e + " on " + MyThreadUtil.name());
                        return e % 2 == 0;
                    })
                    .forEach(System.out::println);

        });
        MyThreadUtil.sleep(1000);
    }

}
