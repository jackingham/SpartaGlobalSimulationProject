package com.sparta.eng82.utilities;


import java.util.Scanner;

public class InputExtension {


    public static boolean outputEveryMonth() {
        Scanner scanner = new Scanner(System.in);

        Printer.printMessage("Enter y/n if you would like to print output every month");
        return scanner.nextLine().equals("y");
    }
}
