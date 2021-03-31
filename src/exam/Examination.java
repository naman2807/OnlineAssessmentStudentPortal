package exam;

import database.DataSource;
import database.DatabaseConnection;
import database.SQlQueries;
import onlineserver.OnlineConnectionServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: exam
 * Project Name: OnlineAssessmentStudentPortal
 * Date: 30-03-2021
 */

public final class Examination {
    private static final Scanner scanner = new Scanner(System.in);

    private Examination() {
    }

    /**
     * @return Examination instance
     */
    public static Examination getInstance() {
        return new Examination();
    }

    /**
     * This method terminates the exam.
     */
    public void endExam() {
        System.exit(0);
    }

    /**
     * This method is used to start the exam and communicate between the invigilator and student.
     *
     * @param input
     * @param output
     * @param studentResponse
     * @param roll
     */
    public void startExam(BufferedReader input, PrintWriter output, String studentResponse, int roll) {
        int response;
        try {
            output.println(roll);
            studentResponse = input.readLine();
            System.out.println(studentResponse);
            if (inputChoice() == 1) {
                String message = "Student had started giving the exam.";
                OnlineConnectionServer.sendMessageToInvigilator(output, message);
                getExamQuestions();
                OnlineConnectionServer.receiveMessageFromInvigilator(input);
                Thread.sleep(5000L);
                System.out.println("Enter the number provided by invigilator to get viva question.");
                if (inputChoice() == 2) {
                    getVivaQuestion();
                    OnlineConnectionServer.sendMessageToInvigilator(output, "Student had started giving the viva");
                } else {
                    System.err.println("Invalid Input");
                    inputChoice();
                }

            } else {
                System.err.println("Invalid Input.");
                inputChoice();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This methods is used for getting exam questions.
     */
    private void getExamQuestions() {
        List<String> questions = DataSource.getQuestions(DatabaseConnection.getConnection(), 2, SQlQueries.showQuestionQuery());
        printQuestions(questions);
    }

    /**
     * This method is used for getting viva questions.
     */
    private void getVivaQuestion() {
        List<String> questions = DataSource.getQuestions(DatabaseConnection.getConnection(), 1, SQlQueries.showVivaQuestionQuery());
        printQuestions(questions);

    }

    /**
     * This method is used to take choice input from student.
     *
     * @return integer value
     */
    private int inputChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    /**
     * This method is used to print questions to console.
     *
     * @param questionsList
     */
    private void printQuestions(List<String> questionsList) {
        System.out.println("Following are the questions for today's exam: ");
        questionsList.forEach(System.out::println);
    }
}
