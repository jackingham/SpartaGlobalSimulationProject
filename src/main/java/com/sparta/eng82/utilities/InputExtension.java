package com.sparta.eng82.utilities;

import com.sparta.eng82.controller.SimulationImpl;
import com.sparta.eng82.model.TrainingCentre;

import java.util.Scanner;

public class InputExtension {



    public static boolean outputEveryMonth() {
        Scanner scanner = new Scanner(System.in);

        Printer.printMessage("Enter y/n if you would like to print output every month");
        return scanner.nextLine().equals("y");

    }

    int getNumberOfOpenCentres() {
        int total = 0;
        for (TrainingCentre trainingCentre : SimulationImpl.trainingCentres) {
            if (trainingCentre.isOpen()) {
                total++;
            }
        }
        return total;
    }

    int getNumberOfCloseCentres() {
        int total = 0;
        for (TrainingCentre trainingCentre : SimulationImpl.trainingCentres) {
            if (!trainingCentre.isOpen()) {
                total++;
            }
        }
        return total;
    }

    int getNumberOfFullCentres() {
        int total = 0;
        for (TrainingCentre trainingCentre : SimulationImpl.trainingCentres) {
            if (!trainingCentre.isOpen()) {
                total++;
            }
        }
        return total;
    }
}
