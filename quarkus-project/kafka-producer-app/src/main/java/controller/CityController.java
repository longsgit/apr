package controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@Path("/cities")
public class CityController {

    @Inject
    @Channel("city-out")
    Emitter<String> emitter;

    @POST
    @Path("/{city}")
    public String postCity(String city) {
        emitter.send(city);
        return "%s posted to kafka".formatted(city);
    }
}
