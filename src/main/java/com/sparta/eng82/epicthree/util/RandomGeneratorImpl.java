package com.sparta.eng82.epicthree.util;

import java.util.Random;

public class RandomGeneratorImpl implements RandomGenerator {
    @Override
    public int randomInt(int upper, int lower) {
        Random random = new Random();
        return random.nextInt(upper - lower) + lower;
    }
}
