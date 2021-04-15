package com.sparta.eng82.model;

import java.util.ArrayList;

public class TrainingCentre {

    private static int idIncrementor = 0;
    private static int numberOfCentreType;
    private final int id;
    private final ArrayList<Trainee> traineeArray = new ArrayList<>();

    private boolean openStatus = true;

    public TrainingCentre(CentreTypes ct) {

        id = idIncrementor++;

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

    public boolean isOpenStatus() {
        return openStatus;
    }

    public void setOpenStatus(boolean openStatus) {
        this.openStatus = openStatus;
    }

    public void removeAllTrainees(){
        traineeArray.clear();
    }
}
