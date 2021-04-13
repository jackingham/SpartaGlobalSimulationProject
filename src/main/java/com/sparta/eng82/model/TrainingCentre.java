package com.sparta.eng82.model;

import java.util.ArrayList;

public class TrainingCentre {

    private static int idIncrementor = 0;
    private final int id;
    private boolean open = true;

    private ArrayList<Trainee> traineeArray = new ArrayList<>();

    public ArrayList<Trainee> getTraineeArray() {
        return traineeArray;
    }

    public TrainingCentre() {
        id = idIncrementor++;
    }

    public boolean isOpen() {
        return open;
    }

    public void setFull() {
        open = false;
    }

    public int getId() {
        return id;
    }

    public int getTraineeArraySize() {
        return traineeArray.size();
    }


}
