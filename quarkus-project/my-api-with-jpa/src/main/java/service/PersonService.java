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

    @Transactional
    public Person updateAge(int id, int newAge) {
        Person person = personRepository.findById((long) id);
        if (person != null) {
            person.setAge(newAge);
            personRepository.persist(person);
        } else {
            throw new RuntimeException("Person with id %s not found".formatted(id));
        }
        return person;
    }


    @Transactional
    public void deletePerson(int id) {
        personRepository.deleteById((long) id);
    }

    public List<Person> getAllPersons() {
        return personRepository.listAll();
    }

    @Transactional
    public Person createPerson(String firstName, String lastName, int age) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setAge(age);
        personRepository.persist(person);
        return person;
    }
}
