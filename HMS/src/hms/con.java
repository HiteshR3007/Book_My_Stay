package hms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class con {
    Connection connection;
    Statement statement;

    public con() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmsdb",
                    "root",
                    "hitesh"
            );


            if (connection != null) {
                statement = connection.createStatement();
                System.out.println("Connection established successfully.");
            } else {
                System.out.println("Failed to establish connection.");
            }

        } catch (Exception e) {
            System.out.println("Connection error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

