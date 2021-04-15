package com.sparta.eng82.model;

import java.util.ArrayList;

public class TrainingCentre {

    private static int idIncrementor = 0;
    private static int numberOfCentreType;
    private final int id;
    private final ArrayList<Trainee> traineeArray = new ArrayList<>();
    private final int traineeCapcity = 100;

    public TrainingCentre(CentreTypes ct) {

        id = idIncrementor++;

    }

    public boolean isOpen() {
        return traineeArray.size() < traineeCapcity;
    }

    public int getId() {
        return id;
    }

    public int getTraineeArraySize() {
        return traineeArray.size();
    }

    public void addTraineeToCentre(Trainee trainee) {
        this.traineeArray.add(trainee);
    }

    public ArrayList<Trainee> getTraineeArray() {
        return traineeArray;
    }

    public void checkIfShouldClose() {
    }

}
