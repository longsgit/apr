package com.herbalife.jdbcwithspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@Component
public class PersonsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Person> getAll() {
        String query = "select * from persons";
        return jdbcTemplate.query(query, (ResultSet resultSet, int rowNum) -> {
            Person person = new Person(resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getInt("age")
            );
            return person;
        });
    }

    public List<String> getAllFirstNames() {
        //YOUR CODE GOES HERE
        return jdbcTemplate.queryForList("select first_name from persons", String.class);
    }

    public List<Map<String, Object>> getAllPersons() {
        //YOUR CODE GOES HERE
        return jdbcTemplate.queryForList("select * from persons");
    }

    public void insert(String firstName, String lastName, int age) {
        String query = "insert into persons(first_name, last_name, age) values(?,?,?)";
        jdbcTemplate.update(query, firstName, lastName, age);
    }

    public void delete(int id) {
        String query = "delete from persons where id=?";
        jdbcTemplate.update(query, id);
    }
}
