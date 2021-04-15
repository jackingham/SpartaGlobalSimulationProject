package com.sparta.eng82.model;

public class Bootcamp extends TrainingCentre {
    public static String centreType = "Bootcamp";
    private static int lifetimeNumberOfBootcamps = 0;
    private static final int MAXIMUMCAPACITY = 500;
    private int numberOfMonthsBelowRequiredAttendance = 0;

    public Bootcamp() {
        super(CentreTypes.BOOTCAMP);
    }

    public static int getMAXIMUMCAPACITY() {
        return MAXIMUMCAPACITY;
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
        return MAXIMUMCAPACITY;
    }
}
