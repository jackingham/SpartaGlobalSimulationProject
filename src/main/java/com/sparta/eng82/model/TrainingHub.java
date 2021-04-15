package com.sparta.eng82.model;

public class TrainingHub extends TrainingCentre {

    private static final int MAXIMUMCAPACITY = 200;
    public static String centreType = "TrainingHub";

    public TrainingHub() {
        super(CentreTypes.TRAINING_HUB);
    }

    public static int getMaximumCapacity() {
        return MAXIMUMCAPACITY;
    }

    @Override
    public void checkIfShouldClose() {
        super.checkIfShouldClose();
    }

    public boolean full() {
        return getTraineeArray().size() == getMaximumCapacity();
    }
}
