package portalcredentialscreator;

import record.student.Student;

import java.util.Random;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: portalcredentialscreator
 * Project Name: OnlineAssessmentStudentPortal
 * Date: 28-03-2021
 */

public class PortalCredentialCreator {

    /**
     * This method is used to generate password.
     *
     * @return password
     */
    public static String createPassword() {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < getPasswordLength(); i++) {
            password.append(getCharacter());
        }
        return password.toString();
    }

    /**
     * this method is used to get password length.
     *
     * @return password length
     */
    private static int getPasswordLength() {
        return (new Random().nextInt(21) + 8) % 20;
    }

    /**
     * this method converts the character into string.
     *
     * @return character in form of string
     */
    private static String getCharacter() {
        return String.valueOf(getRandomCharacter());
    }

    /**
     * This method returns a character to be used in password.
     *
     * @return character
     */
    private static char getRandomCharacter() {
        return (char) new Random().nextInt(Character.MAX_VALUE);
    }

    /**
     * This method creates username for student.
     *
     * @param student
     * @return username
     */
    public static String createUserNameForStudent(Student student) {
        return String.format("%d_%d_%s", student.getClassRollNumber(), student.getCurrentYear(),
                student.getName());
    }

}
