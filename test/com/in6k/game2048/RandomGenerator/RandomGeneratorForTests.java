package com.in6k.game2048.RandomGenerator;

public class RandomGeneratorForTests implements RandomGenerator {
    private int value;

    public RandomGeneratorForTests(int value) {
        this.value = value;
    }

    @Override
    public int getValue(int bound) {
        return value;
    }
}
