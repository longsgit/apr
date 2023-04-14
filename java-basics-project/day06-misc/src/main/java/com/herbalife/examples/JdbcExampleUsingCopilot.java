package com.herbalife.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcExampleUsingCopilot {

    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String AGE = "age";
    public static final String ID = "id";


    public static void main(String[] args) throws SQLException {
        createPerson("Sam", "Thompson", 34);
        loadAllPersons();
    }

    private static void loadAllPersons() throws SQLException {
        System.out.println("Loading all persons");
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.cj.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM persons");
            while (resultSet.next()) {
                String firstName = resultSet.getString(FIRST_NAME);
                String lastName = resultSet.getString(LAST_NAME);
                int age = resultSet.getInt(AGE);
                int id = resultSet.getInt(ID);
                System.out.println("%s, %s, %s, %s".formatted(firstName, lastName, age, id));
            }
            resultSet.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
    }


    private static void createPerson(String firstName, String lastName, int age) throws SQLException {
        System.out.println("Creating person with first name: " + firstName + ", last name: " + lastName + ", age: " + age);
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.cj.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
            connection.createStatement().execute("INSERT INTO persons (first_name, last_name, age) VALUES ('" + firstName + "', '" + lastName + "', " + age + ")");
            connection.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();

        }

    }

}
