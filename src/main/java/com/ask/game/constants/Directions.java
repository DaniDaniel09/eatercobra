package com.ask.game.constants;

import java.util.Random;

public enum Directions {
    LEFT,
    RIGHT,
    UP,
    DOWN;

    public static Directions getRandomDirection() {
        Random random = new Random();
        return values()[random.nextInt(Directions.values().length)];
    }
}
