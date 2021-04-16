package com.sparta.eng82.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BootcampTest {
    Bootcamp bootcamp = new Bootcamp();

    @Test
    @DisplayName("Test that the get method returns the number of months that the bootcamp has had 10 or less students")
    public void shouldReturnZero() {
        Assertions.assertEquals(0, bootcamp.getNumberOfMonthsBelowRequiredAttendance());
    }

    @Test
    @DisplayName("Testing the method for incrementing the number of low attendance months when called")
    public void shouldReturnOne() {
        bootcamp.incrementNumberOfMonthsBelowRequiredAttendance();
        Assertions.assertEquals(1, bootcamp.getNumberOfMonthsBelowRequiredAttendance());
    }

    @Test
    @DisplayName("Testing manually setting the number of months with low trainee attendance")
    public void shouldManuallyChangeTheMonthsWithLowAttendance() {
        bootcamp.setNumberOfMonthsBelowRequiredAttendance(5);
        Assertions.assertEquals(5, bootcamp.getNumberOfMonthsBelowRequiredAttendance());
    }

    @Test
    @DisplayName("Test that the method resets the number of months a bootcamp has had low attendance")
    public void shouldResetTheLowAttendanceMonthsToZero() {
        bootcamp.setNumberOfMonthsBelowRequiredAttendance(6);
        bootcamp.resetNumberOfMonthsBelowRequiredAttendance();
        Assertions.assertEquals(0, bootcamp.getNumberOfMonthsBelowRequiredAttendance());
    }

    @Test
    public void shouldReturnFalseIfTheBootcampIsEmpty() {
        Assertions.assertFalse(bootcamp.full());
    }

}
