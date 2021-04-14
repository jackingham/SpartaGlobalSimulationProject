package com.sparta.eng82.view;

import com.sparta.eng82.model.Trainee;
import com.sparta.eng82.model.TrainingCentre;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class OutputManager implements Output {
    public static ArrayList<TrainingCentre> listOfCentres = new ArrayList<>();
    private static Queue<Trainee> waitingList = new LinkedList<>();


    public OutputManager(ArrayList<TrainingCentre> listOfCentres, Queue waitingList) {
        this.listOfCentres = listOfCentres;
        this.waitingList = waitingList;
    }


    @Override
    public int numberOfCentres() {
        return listOfCentres.size();
    }

    @Override
    public int numberOfOpenCentres() {
        int openCentres = 0;
        for (TrainingCentre openCentre : listOfCentres) {
            if (openCentre.isOpen()) {
                openCentres++;
            }
        }
        return openCentres;
    }

    @Override
    public int numberOfFullCentres() {
//        int fullCentres = 0;
//        for (TrainingCentre fullCentre : listOfCentres) {
//            if (!fullCentre.isOpen()) {
//                fullCentres++;
//            }
//        }
//        return fullCentres;
        return numberOfCentres() - numberOfOpenCentres();
    }

    @Override
    public int numberOfTraineesInTraining() {
        int traineesTraining = 0;
        for (TrainingCentre numberOfTrainees : listOfCentres) {
            traineesTraining += numberOfTrainees.getTraineeArraySize();
        }
        return traineesTraining;
    }

    @Override
    public int numberOfTraineesInWaiting() {
        return waitingList.size();
    }

    @Override
    public void summary() {
        System.out.println("\nTraining Centres: " +
                "\n\tOpen: " + numberOfOpenCentres() +
                "\n\tFull: " + numberOfFullCentres() +
                "\nTrainees: " +
                "\n\tIn Training: " + numberOfTraineesInTraining() +
                "\n\tIn Waiting: " + numberOfTraineesInWaiting()
        );
    }
}
