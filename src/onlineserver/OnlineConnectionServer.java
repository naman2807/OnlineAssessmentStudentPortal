package onlineserver;

import exam.Examination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: onlineserver
 * Project Name: OnlineAssessmentStudentPortal
 * Date: 29-03-2021
 */

public class OnlineConnectionServer {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Examination examination = Examination.getInstance();

    /**
     * This method is used to activate server and connect to invigilator.
     *
     * @param uniRollNumber
     * @param activate
     */
    public static void activateServer(int uniRollNumber, boolean activate) {
        if (activate) {
            try (Socket socket = new Socket("localhost", 5000)) {
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                String studentResponse = null;
                examination.startExam(input, output, studentResponse, uniRollNumber);
                Thread.sleep(10000L);
                OnlineConnectionServer.sendMessageToInvigilator(output, "The time of " + uniRollNumber + " has completed. The exam had " +
                        "been terminated.");
                examination.endExam();
            } catch (IOException | InterruptedException e) {
                System.err.println("Server Problem");
                e.printStackTrace();
            }
        } else {
            examination.endExam();
        }
    }

    /**
     * This method is used to receive message from invigilator.
     *
     * @param input
     * @throws IOException
     */
    public static void receiveMessageFromInvigilator(BufferedReader input) throws IOException {
        String inviglatorResponse = input.readLine();
        System.out.println(inviglatorResponse);
    }

    /**
     * This method is used to send message to invigilator.
     *
     * @param output
     * @param message
     */
    public static void sendMessageToInvigilator(PrintWriter output, String message) {
        output.println(message);
    }
}
