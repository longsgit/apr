package com.herbalife.labs.lab12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MoviesDbUtil {
    private static final String JDBC_MYSQL_LOCALHOST_3306_TRAINING = "jdbc:mysql://localhost:3306/training";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";
    private static Connection connection = null;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insert(String title, int year, String genre, String language) throws SQLException {
        title = title.replaceAll("'", "''");
        try {
            connection = DriverManager.getConnection(JDBC_MYSQL_LOCALHOST_3306_TRAINING, USERNAME, PASSWORD);
            String query = """
                    insert into movies(title, year, genre, language) values('%s',%d,'%s','%s')
                    """;
            Statement statement = connection.createStatement();
            statement.execute(query.formatted(title, year, genre, language));
            statement.close();
        } catch (SQLException e) {
            System.out.println("SQL Error " + title + ", " + language);
        } finally {
            connection.close();
        }
    }
}
