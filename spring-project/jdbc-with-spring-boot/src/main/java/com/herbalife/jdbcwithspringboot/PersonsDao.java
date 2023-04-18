package com.herbalife.jdbcwithspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class PersonsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void callStoredProc(int ageParam) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("sp_sel_persons_with_age_gt");
        simpleJdbcCall.declareParameters(new SqlParameter("age_param", Types.INTEGER));
        Map<String, Object> resultMap = simpleJdbcCall.execute(ageParam);
        resultMap.forEach((key, value) -> {
            System.out.println(key);
            if(value instanceof ArrayList) {
                ((ArrayList<?>) value).forEach(System.out::println);
            }
            System.out.println();
        });
    }

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
