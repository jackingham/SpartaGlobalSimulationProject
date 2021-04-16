package com.sparta.eng82.model;

public class TechCentre extends TrainingCentre {


    private static final Integer MAXIMUMCAPACITY = 200;
    public static String centreType = "TechCentre";
    private final CourseTypes centreCourseName;

    public TechCentre() {
        super(CentreTypes.TECH_CENTRE);
        this.centreCourseName = CourseTypes.getRandomCourseType();
    }

    public static Integer getMaximumCapacity() {
        return MAXIMUMCAPACITY;
    }

    public CourseTypes getCentreCourseName() {
        return centreCourseName;
    }

    public boolean full() {
        return getTraineeArray().size() == getMaximumCapacity();
    }
}
