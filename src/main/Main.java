package main;

import database.DataSource;
import database.DatabaseConnection;
import onlineserver.OnlineConnectionServer;

import java.util.Scanner;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: main
 * Project Name: OnlineAssessmentStudentPortal
 * Date: 29-03-2021
 */

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        databaseConnect();
        validateStudent();
    }

    /**
     * This method is used to enter details of student.
     */
    private static void validateStudent() {
        System.out.println("Enter University Roll Number: ");
        int roll = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter  username: ");
        String username = scanner.nextLine();
        System.out.println("Enter Password: ");
        String password = scanner.nextLine();
        checkStudent(roll, username, password);
    }

    /**
     * This method is used to check validity student.
     *
     * @param roll
     * @param username
     * @param password
     */
    private static void checkStudent(int roll, String username, String password) {
        if (DataSource.checkStudentValidity(DatabaseConnection.getConnection(), roll, username, password)) {
            System.out.println("Access Granted");
            instructions(roll);
        } else {
            System.err.println("Access Denied. Check Your Id, Username and Password.");
            validateStudent();
        }
    }

    /**
     * This method is used to print further instructions.
     *
     * @param roll
     */
    private static void instructions(int roll) {
        System.out.println("*".repeat(100) + "\nPress 1 to mark your attendance.");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            startOnlineExam(roll);
        } else {
            System.err.println("Invalid Input");
        }
    }

    /**
     * This method is used to start exam.
     *
     * @param roll
     */
    private static void startOnlineExam(int roll) {
        OnlineConnectionServer.activateServer(roll, true);
    }

    /**
     * This method connect to database.
     */
    private static void databaseConnect() {
        DatabaseConnection.connectToDatabase();
    }
}
