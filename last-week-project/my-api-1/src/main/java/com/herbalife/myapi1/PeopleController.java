package com.herbalife.myapi1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Tag(name = "People Controller", description = "CRUD operations on people")
@RestController
@RequestMapping("/persons")
public class PeopleController {

    @GetMapping
    @Operation(description = "fetch all persons")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "list of all persons")
    })
    public List<Person> getAllPersons() {
        return Arrays.asList();
    }

    @PostMapping
    public void createPerson(@RequestBody Person person) {

    }

    public void doSomething() {
        Person person = new Person();
    }
}
