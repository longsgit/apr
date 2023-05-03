package controller;

import dto.PersonDto;
import entity.Person;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import service.PersonService;

import java.util.List;

@Path("/persons")
public class PersonController {
    @Inject
    private PersonService personService;

    @GET
    public List<Person> getAll() {
        return personService.getAllPersons();
    }

    @POST
//    public Person createPerson(@Valid @RequestBody PersonDto personDto) { }
    public Person createPerson(PersonDto personDto) {
        return personService.createPerson(personDto.firstName(), personDto.lastName(), personDto.age());
    }
}
