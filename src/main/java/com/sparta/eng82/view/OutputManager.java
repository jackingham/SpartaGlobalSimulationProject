package com.sparta.eng82.view;

import com.sparta.eng82.model.TrainingCentre;

import java.util.List;
import java.util.Queue;

public class OutputManager implements Output {
    //    private
    private List<TrainingCentre> listOfCentres;
    private Queue waitingList;


    public OutputManager(List<TrainingCentre> listOfCentres, Queue waitingList) {
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
        int fullCentres = 0;
        for (TrainingCentre fullCentre : listOfCentres) {
            if (!fullCentre.isOpen()) {
                fullCentres++;
            }
        }
        return fullCentres;
    }

    @Override
    public int numberOfTraineesInTraining() {
        int traineesTraining = 0;
        for (TrainingCentre trainingCentre : listOfCentres) {
            if (trainingCentre.getTraineeArraySize() != 0) {
                traineesTraining += trainingCentre.getTraineeArraySize();
                System.out.println(trainingCentre.getTraineeArraySize());
                break;
            }
        }
        return traineesTraining;
    }

    @Override
    public int numberOfTraineesInWaiting() {
        return waitingList.size();
    }

    @Override
    public String summary() {
        return "\nTraining Centres:" +
                "\n\tOpen: " + numberOfCentres() +
                "\n\tFull: " + numberOfOpenCentres() +
                "\n\tClosed: " + numberOfFullCentres() +
                "\nTrainees: " +
                "\n\tIn Training: " + numberOfTraineesInTraining() +
                "\n\tIn Waiting: " + numberOfTraineesInWaiting();
    }


}
