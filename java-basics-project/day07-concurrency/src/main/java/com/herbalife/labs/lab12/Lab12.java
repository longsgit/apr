package com.herbalife.labs.lab12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Lab12 {
    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        List<String> movies = Files.readAllLines(Paths.get("./movies.txt"));
        MoviesFetcher moviesFetcher = new MoviesFetcher();
        CompletableFuture.supplyAsync(() -> moviesFetcher.fetchMovieDetails(movies), es)
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
