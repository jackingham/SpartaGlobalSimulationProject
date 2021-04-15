package com.sparta.eng82.model;

public class TechCentre extends TrainingCentre {
    public  String centreType = "TechCentre";
    private static final int MAXIMUMCAPACITY = 200;


    private final CourseTypes centreCourseName;


    public TechCentre() {
        super(CentreTypes.TECH_CENTRE);
        this.centreCourseName = CourseTypes.getRandomCourseType();
    }

    public CourseTypes getCentreCourseName() {
        return centreCourseName;
    }

    @Override
    public void checkIfShouldClose() {
        super.checkIfShouldClose();
    }

    public static int getMaximumCapacity() {
        return MAXIMUMCAPACITY;
    }

    public boolean full(){
        return getTraineeArray().size() == getMaximumCapacity();
    }
}
