package repo;

import entity.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

//Very different from JpaRepository
//JpaRepository is an interface with a lot of conventional methods
//JPQL syntax is different from Panache

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {
    public List<Person> findAllByFirstName(String firstName) {
        return list("firstName", firstName);
    }

    public List<Person> findAllByFirstNameAndLastName(String firstName, String lastName) {
        return list("firstName = ?1 and lastName = ?1", firstName, lastName);
    }
}
