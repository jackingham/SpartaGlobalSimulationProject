package com.sparta.eng82.model;

public class Bootcamp extends TrainingCentre {

    private static final int capacity = 500;

    public Bootcamp(){
        super(CentreTypes.BOOTCAMP);
    }

    @Override
    public void checkIfShouldClose() {
        super.checkIfShouldClose();
    }
}
