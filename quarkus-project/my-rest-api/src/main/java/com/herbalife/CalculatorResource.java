package com.herbalife;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

@Path("/calc")
public class CalculatorResource {

    @Inject
    private CalculatorService calculatorService;

    @GET()
    @Path("/sum/{num1}/{num2}")
    public int add(@PathParam("num1") int num1, @PathParam("num2") int num2) {
        return num1 + num2;
    }

    @GET
    @Path("/square/{num}")
    public int square(int num) {
        return num * num;
    }

    @GET
    @Path("/cube")
    public int cube(@QueryParam("num") int num) {
        return num * num * num;
    }
}
