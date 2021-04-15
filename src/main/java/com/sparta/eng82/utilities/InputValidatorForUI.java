package com.sparta.eng82.utilities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidatorForUI {

    private static final Scanner scanner = new Scanner(System.in);
    public static int getUserInput(String userTimeChoice, int years,int months) {//edited
        try {

            switch (userTimeChoice) {

                case "m":
                    return months;

                case "y":
                    return years * 12;

                case "ym":
                case "my":

                    return (years*12) + months;

                default:
                    break;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}

