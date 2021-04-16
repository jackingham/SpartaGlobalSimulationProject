package com.sparta.eng82.utilities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getUserInput() {
        System.out.println("Are you entering months, years or a combination of both?");

        String userTimeChoice = verifyTimeframe();
        try {

            switch (userTimeChoice) {

                case "m":
                    System.out.println("Enter for how many months the simulation should run: ");
                    return verifyInteger();

                case "y":
                    System.out.println("Enter for how many years the simulation should run: ");
                    return verifyInteger() * 12;

                case "ym":
//                case "my":
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

        int input = 0;
        do {
            System.out.println("Enter a positive whole number");
            try {
                input = scanner.nextInt();
            } catch (InputMismatchException e) { // if the user enters something that is not an integer
                System.out.println("Please only enter integers");
                input = Integer.MIN_VALUE;
                scanner.next(); // consume the non-int so we don't get caught in an endless loop
            }
        } while (input < 1);
        return input;
    }


    public static String verifyTimeframe() {
        System.out.println("choose Y, M or YM");
        String chosenTime = (scanner.nextLine()).toLowerCase();
        while (!(chosenTime.equalsIgnoreCase("y") || chosenTime.equalsIgnoreCase("m") || chosenTime.equalsIgnoreCase("my") || chosenTime.equalsIgnoreCase("ym"))) {
            System.out.println("try again, please choose Y, M or YM");
            chosenTime = (scanner.nextLine()).toLowerCase();
        }
        return chosenTime;
    }


}
