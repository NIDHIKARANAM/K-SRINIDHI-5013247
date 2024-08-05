package deepskilling;

import java.util.Scanner;

public class TestLogger {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first log message:");
        String firstMessage = scanner.nextLine();
        logger1.log(firstMessage);

        System.out.println("Enter the second log message:");
        String secondMessage = scanner.nextLine();
        logger2.log(secondMessage);

        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("logger1 and logger2 are different instances.");
        }

        scanner.close();
    }
}