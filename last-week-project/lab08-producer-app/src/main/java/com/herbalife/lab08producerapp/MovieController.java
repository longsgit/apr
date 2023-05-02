package com.herbalife.lab08producerapp;

import com.herbalife.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    private StreamBridge streamBridge;

    @PostMapping("/movies")
    public String postMovie(@RequestBody Movie movie) {
        streamBridge.send("movie-out-0", movie);
        return "%s sent to kakfa".formatted(movie.getTitle());
    }
}
