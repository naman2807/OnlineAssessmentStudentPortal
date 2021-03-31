package database;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: database
 * Project Name: OnlineAssessmentStudentPortal
 * Date: 28-03-2021
 */

public final class SQlQueries {
    private static final String STUDENT_TABLE = "students";
    private static final String STUDENT_NAME = "name";
    private static final String STUDENT_CLASS_ROLL_NUMBER = "class_roll_number";
    private static final String STUDENT_UNI_ROLL_NUMBER = "uni_roll_number";
    private static final String STUDENT_SECTION = "section";
    private static final String STUDENT_CURRENT_YEAR = "current_year";
    private static final String STUDENT_COURSE = "course";
    private static final String STUDENT_USERNAME = "username";
    private static final String STUDENT_PASSWORD = "password";
    private static final String QUESTION_BANK_TABLE = "questionbank";
    private static final String QUESTION_SERIAL_NUMBER = "serial_number";
    private static final String QUESTION = "question";
    private static final String VIVA_QUESTION_TABLE = "vivaquestion";
    private static final String VIVA_QUESTION_SERIAL_NUMBER = "s_no";
    private static final String VIVA_QUESTION = "question";

    /**
     * @return SQL query for showing questions.
     */
    public static final String showQuestionQuery() {
        return "SELECT * FROM " + QUESTION_BANK_TABLE + " WHERE " + QUESTION_SERIAL_NUMBER + " = ?";
    }

    /**
     * @return SQL query for showing viva questions.
     */
    public static final String showVivaQuestionQuery() {
        return "SELECT * FROM " + VIVA_QUESTION_TABLE + " WHERE " + VIVA_QUESTION_SERIAL_NUMBER + " = ?";
    }

    public static final String findStudentQuery() {
        return "SELECT * FROM " + STUDENT_TABLE + " WHERE " + STUDENT_UNI_ROLL_NUMBER +
                " = ?";
    }

}
