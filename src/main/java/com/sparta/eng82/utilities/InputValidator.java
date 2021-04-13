package com.sparta.eng82.utilities;

import java.util.Scanner;

public class InputValidator {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getUserInput() {
        System.out.println("Are you entering months, years or a combination of both? (m/y/ym)");

        try {
            String userTimeChoice = (scanner.nextLine()).toLowerCase();

            switch (userTimeChoice) {

                case "m":
                    System.out.println("Enter for how many months the simulation should run: ");
                    return verifyInteger();

                case "y":
                    System.out.println("Enter for how many years the simulation should run: ");
                    return verifyInteger() * 12;

                case "ym":
                case "my":
                    System.out.println("Enter how many years the simulation should run for: ");
                    int months = verifyInteger() * 12;
                    System.out.println("Enter for how many months the simulation should run: ");
                    return verifyInteger() + months;

                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int verifyInteger() {
        while (!scanner.hasNextInt()) {
            System.out.println("That's not a number!");
            scanner.next(); // this is important!
        }

        return scanner.nextInt();
    }
}
