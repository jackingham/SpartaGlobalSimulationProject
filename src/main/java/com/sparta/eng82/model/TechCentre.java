package com.sparta.eng82.model;

public class TechCentre extends TrainingCentre{

    private final String centreCourseName;

    public TechCentre(String centreCourseName){
        super(200);
        this.centreCourseName = centreCourseName;
    }

    @Override
    public void checkIfShouldClose() {
        super.checkIfShouldClose();
    }
}
