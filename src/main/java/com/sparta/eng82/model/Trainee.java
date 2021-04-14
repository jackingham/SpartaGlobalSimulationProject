package com.sparta.eng82.model;

public class Trainee {
    private static int idIncrementor = 0;
    private final int id;
    private final int joinMonth;
    private final String courseName;


    public Trainee(int joinMonth) {
        this.joinMonth = joinMonth;
        id = idIncrementor++;
        this.courseName = CourseTypes.getRandomCourseType();
    }

    public int getId() {
        return id;
    }

    public int getJoinMonth() {
        return joinMonth;
    }
}
