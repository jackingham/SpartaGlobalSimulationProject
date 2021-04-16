package com.sparta.eng82.model;

public class Trainee {
    private static Integer idIncrementor = 0;
    private final Integer id;
    private final Integer joinMonth;
    private final CourseTypes courseName;

    public Trainee(Integer joinMonth) {
        this.joinMonth = joinMonth;
        id = idIncrementor++;
        this.courseName = CourseTypes.getRandomCourseType();
    }

    public CourseTypes getCourseName() {
        return courseName;
    }

    public Integer getId() {
        return id;
    }

    public Integer getJoinMonth() {
        return joinMonth;
    }
}
