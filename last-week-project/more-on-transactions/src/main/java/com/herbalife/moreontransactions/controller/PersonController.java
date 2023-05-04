package com.herbalife.moreontransactions.controller;

import com.herbalife.moreontransactions.entity.Person;
import com.herbalife.moreontransactions.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/family")
    public void insertFamily(@RequestBody List<Person> persons) {
        System.out.println("****** " + personService.getClass().getName());
        System.out.println("****** " + personService.getClass().getSuperclass().getName());

        //personService.saveFamily(persons);
    }
}
