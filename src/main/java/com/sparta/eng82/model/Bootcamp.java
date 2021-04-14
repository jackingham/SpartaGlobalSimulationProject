package com.sparta.eng82.model;

public class Bootcamp extends TrainingCentre {

    private static int lifetimeNumberOfBootcamps = 0;
    private static final int maximumCapacity = 500;
    private int numberOfMonthsBelowRequiredAttendance = 0;

    public Bootcamp() {
        super(CentreTypes.BOOTCAMP);
    }

    @Override
    public void checkIfShouldClose() {
        super.checkIfShouldClose();
    }

    public static int getLifetimeNumberOfBootcamps() {
        return lifetimeNumberOfBootcamps;
    }

    public static void incrementLifetimeNumberOfBootcamps() {
        Bootcamp.lifetimeNumberOfBootcamps++;
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

    public static int getMaximumCapacity() {
        return maximumCapacity;
    }
}
