package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: databse
 * Project Name: OnlineAssessmentStudentPortal
 * Date: 28-03-2021
 */

public final class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/onlineassessment";
    private static final String root = "root";
    private static final String password = "";

    private DatabaseConnection(){}

    private static Connection connection;

    /**
     * This method return an instance of Connection type.
     *
     * @return connection
     */
    public static Connection getConnection() {
        return connection;
    }

    /**
     * This method do the connection to database.
     */
    public static void connectToDatabase() {
        try {
            connection = DriverManager.getConnection(URL, root, password);
            System.out.println("Database connected Successfully");
        } catch (SQLException e) {
            System.err.println("Couldn't connect to database.");
            e.printStackTrace();
        }
    }

}
