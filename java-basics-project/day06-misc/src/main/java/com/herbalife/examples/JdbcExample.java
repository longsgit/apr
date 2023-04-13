package com.herbalife.examples;

import java.sql.*;

public class JdbcExample {
    public static void main(String[] args) throws SQLException {
        //load the mysql driver
        //create a connection
        //create sql statement
        //execute the statement
        //close connection
        //handle exceptions
//        createPerson("Ram", "Narain", 32);
//        createPerson("Mary", "Joe", 45);
        //loadAll();
        loadAllPersonsWithAgeGt(20);
    }

    /*
    CREATE DEFINER=`root`@`%` PROCEDURE `sp_sel_persons_with_age_gt`(in age_param int)
    BEGIN
	    select * from persons where age > age_param;
    END
    *
    * */

    private static void loadAllPersonsWithAgeGt(int ageParam) throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
            String query = "{call sp_sel_persons_with_age_gt(?)}";
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt("age_param", ageParam);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                System.out.println("%s, %s, %s, %s".formatted(id, firstName, lastName, age));
            }
            resultSet.close();
            callableStatement.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    private static void loadAll() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
            Statement statement = connection.createStatement();
            String query = "select * from persons";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                System.out.println("%s, %s, %s, %s".formatted(id, firstName, lastName, age));
            }
            resultSet.close();
            statement.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
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
