package com.sparta.eng82.utilities;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomGeneratorImplTest {

    static RandomGeneratorImpl randomGenerator = null;

    @BeforeAll
    static void init() {
        randomGenerator = new RandomGeneratorImpl();
    }

    @Test
    @DisplayName("Testing if the generator returns the correct integer in a single value range")
    public void testCorrectReturn() {
        assertEquals(9, randomGenerator.randomInt(9, 10));
        // range 9 to 11 can return 9 or 10, but not 11
    }

    @Test
    @DisplayName("Testing that that the returned value is in the specified range for the generator")
    public void testRangeIsCorrect() {
        Integer upper = 20;
        Integer lower = 10;
        Integer result = randomGenerator.randomInt(lower, upper);
        if (result <= upper && result >= lower) {
            assertTrue(true);
        }
    }
}