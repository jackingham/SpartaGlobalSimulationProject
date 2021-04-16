package com.sparta.eng82.model;

import java.util.ArrayList;

public class TrainingCentre {

    private static Integer idIncrementor = 0;
    private static Integer numberOfCentreType;
    private final Integer id;
    private final ArrayList<Trainee> traineeArray = new ArrayList<>();

    private boolean openStatus = true;      // Whether we are accepting new trainees.
    private boolean functionStatus = true;  // Whether we are closed for good.

    public TrainingCentre(CentreTypes ct) {

        id = idIncrementor++;

    }


    public Integer getId() {
        return id;
    }

    public Integer getTraineeArraySize() {
        return traineeArray.size();
    }

    public void addTraineeToCentre(Trainee trainee) {
        this.traineeArray.add(trainee);
    }

    public ArrayList<Trainee> getTraineeArray() {
        return this.traineeArray;
    }

    public boolean isOpenStatus() {
        return this.openStatus;
    }

    public void setOpenStatus(boolean openStatus) {
        this.openStatus = openStatus;
    }

    public void removeAllTrainees(){
        this.traineeArray.clear();
    }

    public boolean getFunctionStatus() {
        return functionStatus;
    }

    public void setFunctionStatus(boolean functionStatus) {
        this.functionStatus = functionStatus;
    }
}
