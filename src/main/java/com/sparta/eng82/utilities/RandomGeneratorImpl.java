package com.sparta.eng82.utilities;

import java.util.Random;

public class RandomGeneratorImpl implements RandomGenerator {
    Random random = new Random();

    @Override
    public Integer randomInt(Integer lower, Integer upper) {

        return random.nextInt(upper - lower) + lower;
    }

}
