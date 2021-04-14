package com.sparta.eng82.model;

public class TechCentre extends TrainingCentre{

    private static final int capacity = 100;

    private final String centreCourseName;

    public TechCentre(){
        super(CentreTypes.TECH_CENTRE);
        this.centreCourseName = CourseTypes.getRandomCourseType();
    }

    @Override
    public void checkIfShouldClose() {
        super.checkIfShouldClose();
    }
}
