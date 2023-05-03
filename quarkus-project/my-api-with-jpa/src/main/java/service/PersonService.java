package service;

import entity.Person;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import repo.PersonRepository;

import java.util.List;

@ApplicationScoped
public class PersonService {

    @Inject
    private PersonRepository personRepository;

    @Transactional
    public Person createPerson(Person person) {
        personRepository.persist(person);
        return person;
    }

    public List<Person> getAllPersons() {
        return personRepository.listAll();
    }

}
