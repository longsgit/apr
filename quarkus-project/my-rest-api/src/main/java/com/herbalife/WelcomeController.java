package com.herbalife;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/welcome")
public class WelcomeController {

    @GET
    @Path("/hello")
    public String hello() {
        return "Welcome to quarkus training";
    }
}
