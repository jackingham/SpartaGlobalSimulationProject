package com.sparta.eng82.model;

import java.util.Random;

public enum CentreTypes {
    BOOTCAMP, TRAINING_HUB, TECH_CENTRE;

    public static CentreTypes getRandomCentreType() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

    public static String getBootCampType() {
        return String.valueOf(BOOTCAMP);
    }

    public static String getTrainingHubType() {
        return String.valueOf(TRAINING_HUB);
    }

    public static String getTechCentreType() {
        return String.valueOf(TECH_CENTRE);
    }

}
