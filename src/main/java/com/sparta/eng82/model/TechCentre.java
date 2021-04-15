package com.sparta.eng82.model;

public class TechCentre extends TrainingCentre {
    private static final int MAXIMUMCAPACITY = 200;
    public static String centreType = "TechCentre";
    private final CourseTypes centreCourseName;


    public TechCentre() {
        super(CentreTypes.TECH_CENTRE);
        this.centreCourseName = CourseTypes.getRandomCourseType();
    }

    public static int getMaximumCapacity() {
        return MAXIMUMCAPACITY;
    }

    public CourseTypes getCentreCourseName() {
        return centreCourseName;
    }

    @Override
    public void checkIfShouldClose() {
        super.checkIfShouldClose();
    }

    public boolean full() {
        return getTraineeArray().size() == getMaximumCapacity();
    }
}