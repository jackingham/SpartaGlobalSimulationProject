package com.sparta.eng82.model;

public class TrainingHub extends TrainingCentre{

    private static final int maximumCapacity = 200;

    public TrainingHub(){
        super(CentreTypes.TRAINING_HUB);
    }

    @Override
    public void checkIfShouldClose() {
        super.checkIfShouldClose();
    }

    public static int getMaximumCapacity() {
        return maximumCapacity;
    }
}
