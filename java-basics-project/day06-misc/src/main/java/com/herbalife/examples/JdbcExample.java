package com.herbalife.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExample {
    public static void main(String[] args) throws SQLException {
        //load the mysql driver
        //create a connection
        //create sql statement
        //execute the statement
        //close connection
        //handle exceptions
        createPerson("Ram", "Narain", 32);
        createPerson("Mary", "Joe", 45);
    }

    private static void createPerson(String firstName, String lastName, int age) throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
            Statement statement = connection.createStatement();
            String query = """
                    insert into persons(first_name, last_name, age) values('%s','%s','%d')
                    """.formatted(firstName, lastName, age);
            statement.executeUpdate(query);
            statement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}
