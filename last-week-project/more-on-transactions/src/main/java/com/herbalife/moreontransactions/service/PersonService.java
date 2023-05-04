package com.herbalife.moreontransactions.service;

import com.herbalife.moreontransactions.entity.Person;
import com.herbalife.moreontransactions.repo.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional (Not recommended)
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    //TransactionTemplate
    @Transactional(dontRollbackOn = SillyException.class)
    public void saveFamily(List<Person> persons) {
        persons.forEach(person -> personRepository.save(person));
    }
}
