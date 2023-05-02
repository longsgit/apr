package com.herbalife.lab08consumerkafkaapp;

import com.herbalife.model.Movie;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.stereotype.Component;

@Component
public class MovieCustomErrorHandlingDeserializer extends ErrorHandlingDeserializer<Movie> {
    @Override
    public Movie deserialize(String topic, byte[] data) {
        if("dummy".equalsIgnoreCase(new String(data))) {
            System.out.println("XXXXXXXXX - Corrupt data: " + new String(data));
            Movie movie = new Movie();
            movie.setTitle("Unknown movie");
            return movie;
        }
        return super.deserialize(topic, data);
    }
}
