package com.sparta.eng82.model;

import java.util.Random;

public enum CourseTypes {
    JAVA, C_SHARP, DATA, DEVOPS, BUSINESS;

    public static CourseTypes getRandomCourseType() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
