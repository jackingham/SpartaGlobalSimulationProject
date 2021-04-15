package com.sparta.eng82.utilities;

import java.util.Scanner;

public class InputExtension {

    private static final Scanner scanner = new Scanner(System.in);

    public static boolean outputEveryMonth() {
        Printer.printMessage("Enter y/n if you would like to print output every month");
        return scanner.nextLine().equals("y");
    }
}
