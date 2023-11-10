package cse470;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
    private final static String JDBC_URL = "jdbc:mysql://localhost:3306/cse470";
    private final static String DB_USER = "root";
    private final static String DB_PASSWORD = "Trinhhuukhoi0105!";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection mySQLClient = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
            // Select some information from the "testdb" database
            String query = "SELECT id, Courser_Name FROM course;";
            
            try (PreparedStatement preparedStatement = mySQLClient.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        // Retrieve data from the result set
                        String column1Value = resultSet.getString("id");
                        String column2Value = resultSet.getString("Courser_Name");

                        // Do something with the retrieved data
                        System.out.println("Column 1: " + column1Value + ", Column 2: " + column2Value);
                    }
                }
            }
        }
    }
}

