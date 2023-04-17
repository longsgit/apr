package com.herbalife.labs.lab12;

import com.herbalife.examples.MyThreadUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.*;

public class Lab12 {
    public static void main(String[] args) throws Exception {

        ExecutorService es = Executors.newFixedThreadPool(2);
        List<String> movies = Files.readAllLines(Paths.get("./movies.txt"));
        MoviesFetcher moviesFetcher = new MoviesFetcher();
        CompletableFuture.supplyAsync(() -> {
                    try {
                        return moviesFetcher.fetchMovieDetails(movies);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                }, es)
                .thenAccept(moviesMap -> {
                    System.out.println("***Successful movies***");
                    moviesMap
                            .get(true)
                            .forEach(System.out::println);

                    System.out.println("***ERROR movies***");
                    moviesMap
                            .get(false)
                            .forEach(System.out::println);
                });

        System.out.println("End of main");
        es.awaitTermination(1, TimeUnit.MINUTES);
    }
}
