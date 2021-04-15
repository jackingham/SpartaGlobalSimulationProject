package com.sparta.eng82.model;

public class Bootcamp extends TrainingCentre {
    private static final int MAXIMUMCAPACITY = 500;
    public static String centreType = "Bootcamp";
    private static int lifetimeNumberOfBootcamps = 0;
    private int numberOfMonthsBelowRequiredAttendance = 0;

    public Bootcamp() {
        super(CentreTypes.BOOTCAMP);
    }

    public static int getLifetimeNumberOfBootcamps() {
        return lifetimeNumberOfBootcamps;
    }

    public static void incrementLifetimeNumberOfBootcamps() {
        Bootcamp.lifetimeNumberOfBootcamps++;
    }

    public static int getMaximumCapacity() {
        return MAXIMUMCAPACITY;
    }

    public int getNumberOfMonthsBelowRequiredAttendance() {
        return numberOfMonthsBelowRequiredAttendance;
    }

    public void incrementNumberOfMonthsBelowRequiredAttendance() {
        this.numberOfMonthsBelowRequiredAttendance++;
    }

    public void resetNumberOfMonthsBelowRequiredAttendance() {
        this.numberOfMonthsBelowRequiredAttendance = 0;
    }

    public boolean full() {
        return getTraineeArray().size() == getMaximumCapacity();
    }


    public static void setLifetimeNumberOfBootcamps(int lifetimeNumberOfBootcamps) {
        Bootcamp.lifetimeNumberOfBootcamps = lifetimeNumberOfBootcamps;
    }

    public void setNumberOfMonthsBelowRequiredAttendance(int numberOfMonthsBelowRequiredAttendance) {
        this.numberOfMonthsBelowRequiredAttendance = numberOfMonthsBelowRequiredAttendance;
    }
}
