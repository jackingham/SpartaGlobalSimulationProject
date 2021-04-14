package com.sparta.eng82.utilities;

import java.util.Random;

public class RandomGeneratorImpl implements RandomGenerator {
    Random random = new Random();

    @Override
    public int randomInt(int lower, int upper) {

        return random.nextInt(upper - lower) + lower;
    }

}
