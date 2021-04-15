package com.sparta.eng82.model;

public class TechCentre extends TrainingCentre {

    private static final int MAXIMUMCAPACITY = 100;

    private final CourseTypes centreCourseName;

    public TechCentre() {
        super(CentreTypes.TECH_CENTRE);
        this.centreCourseName = CourseTypes.getRandomCourseType();
    }

    @Override
    public void checkIfShouldClose() {
        super.checkIfShouldClose();
    }

    public static int getMaximumCapacity() {
        return MAXIMUMCAPACITY;
    }
}
