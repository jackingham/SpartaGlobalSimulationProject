package com.sparta.eng82.View;

import com.sparta.eng82.objects.Trainee;
import com.sparta.eng82.objects.TrainingCentre;

import java.util.List;

public class OutputManager implements Output {
    private List<TrainingCentre> listOfCentres;
    private List<Trainee> listOfTrainee;


    public OutputManager(List<TrainingCentre> listOfCentres, List<Trainee> listOfTrainee) {
        this.listOfCentres = listOfCentres;
        this.listOfTrainee = listOfTrainee;
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
        int fullCentres = 0;
        for (TrainingCentre fullCentre : listOfCentres) {
            if (!fullCentre.isOpen()) {
                fullCentres++;
            }
        }
        return fullCentres;
    }

    @Override
    public int numberOfTraineesInWaiting() {
        return 0;
    }


}
