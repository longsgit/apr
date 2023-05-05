package com.herbalife;

import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/welcome")
public class WelcomeController {

    @GET
    @Path("/hello")
    public String hello() {
        return "Welcome to quarkus training";
    }


    @POST
    @Path("/items")
    public String create(@Valid Item item) {
        return "Created " + item.getName();
    }
}
