package com.in6k.game2048.RandomGenerator;

import java.util.Random;

public class RandomGeneratorImpl implements RandomGenerator {
    private Random random = new Random();

    @Override
    public int getValue(int bound) {
        return random.nextInt(bound);
    }
}
