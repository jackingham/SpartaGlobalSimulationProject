package com.sparta.eng82.model;

public class TrainingHub extends TrainingCentre {

    private static final Integer MAXIMUMCAPACITY = 100;
    public static String centreType = "TrainingHub";

    public TrainingHub() {
        super(CentreTypes.TRAINING_HUB);
    }

    public static Integer getMaximumCapacity() {
        return MAXIMUMCAPACITY;
    }

    public boolean full() {
        return getTraineeArray().size() == getMaximumCapacity();
    }
}
