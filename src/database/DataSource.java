package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: database
 * Project Name: OnlineAssessmentStudentPortal
 * Date: 29-03-2021
 */

public final class DataSource {

    private DataSource() {
    }

    /**
     * This method checks whether the student exists in record or not.
     *
     * @param connection
     * @param uniRollNumber
     * @param userName1
     * @param password1
     * @return boolean value: true if valid. false otherwise.
     */
    public static boolean checkStudentValidity(Connection connection, int uniRollNumber, String userName1, String password1) {
        try {
            String userName = null;
            String password = null;
            PreparedStatement preparedStatement = connection.prepareStatement(SQlQueries.findStudentQuery());
            preparedStatement.setInt(1, uniRollNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return false;
            } else {
                while (resultSet.next()) {
                    userName = resultSet.getString(7);
                    password = resultSet.getString(8);
                }
                if (userName == null || !userName.equals(userName1) || !password.equals(password1)) {
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * This method returns the list of questions to be asked in exam for each student.
     *
     * @param connection
     * @param numberOfQuestions
     * @param query
     * @return list of questions
     */
    public static List<String> getQuestions(Connection connection, int numberOfQuestions, String query) {
        List<String> questions = new ArrayList<>();
        for (int i = 0; i < numberOfQuestions; i++) {
            int random = new Random().nextInt(10);
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, random);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String question = resultSet.getString(2);
                    questions.add(question);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return questions;
    }
}
