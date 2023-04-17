package com.herbalife.labs.lab12;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Collectors;

public class MoviesFetcher {
    private String baseUrl = "http://www.omdbapi.com/?i=tt3896198&apikey=52d1c7f&t=%s";
    private HttpClient httpClient = HttpClient.newBuilder().build();
    private ObjectMapper objectMapper = new ObjectMapper();
    private ForkJoinPool forkJoinPool = new ForkJoinPool((int) (Runtime.getRuntime().availableProcessors() / (1 - 0.9)));

    public Map<Boolean, List<MovieModel>> fetchMovieDetails(List<String> movies) throws ExecutionException, InterruptedException {
       var forkJoinTask = forkJoinPool.submit(() -> {
           Map<Boolean, List<MovieModel>> moviesMap = movies
                   .stream()
                   .parallel()
                   .map(this::fetchDetailsFromOmdb)
                   .filter(e -> e != null)
                   .map(this::parseMovieResponse)
                   .collect(Collectors.groupingBy(MovieModel::isResponse));
           moviesMap
                   .get(true)
                   .stream()
                   .parallel()
                   .forEach(movieModel -> {
                       try {
                           MoviesDbUtil.insert(movieModel.getTitle(), movieModel.getYear(), movieModel.getGenre(), movieModel.getLanguage());
                       } catch (SQLException e) {
                           e.printStackTrace();
                       }
                   });
           return moviesMap;
       });
        return forkJoinTask.get();
    }

    private MovieModel parseMovieResponse(String movieDetailsJson) {
        MovieModel movieModel = null;
        try {
            movieModel = objectMapper.readValue(movieDetailsJson, MovieModel.class);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return movieModel;
    }

    private String fetchDetailsFromOmdb(String title) {
        title = URLEncoder.encode(title, Charset.defaultCharset());
        String url = baseUrl.formatted(title);
        String result = null;
        HttpRequest req = null;
        try {
            req = HttpRequest
                    .newBuilder(new URI(url))
                    .GET()
                    .build();
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        }
        HttpResponse<String> response = null;
        try {
            response = httpClient.send(req, HttpResponse.BodyHandlers.ofString());
            result = response.body();
            if (result != null && result.contains("Response: \"False\"")) {
                result.replace("{", "{Title: \"" + title + "\", ");
                System.out.println(result);
            }
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
}
