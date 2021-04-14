package com.sparta.eng82.model;

import java.util.Random;

public enum CourseTypes {
    JAVA, C_SHARP, DATA, DEVOPS, BUSINESS;

    public static String getRandomCourseType() {
        Random random = new Random();
        return String.valueOf(values()[random.nextInt(values().length)]);
    }
}
