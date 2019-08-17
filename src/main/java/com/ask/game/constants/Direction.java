package com.ask.game.constants;

import java.util.Random;

public enum Direction {
    LEFT,
    RIGHT,
    UP,
    DOWN;

    public static Direction getRandomDirection() {
        Random random = new Random();
        return values()[random.nextInt(Direction.values().length)];
    }
}
