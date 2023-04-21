package com.ask.game.constants;

import java.util.Random;

/**
 *
 * @author Daniel/DaniDaniel09
 */
public enum Direction {

    /**
     *
     */
    LEFT,

    /**
     *
     */
    RIGHT,

    /**
     *
     */
    UP,

    /**
     *
     */
    DOWN;

    /**
     *
     * @return
     */
    public static Direction getRandomDirection() {
        Random random = new Random();
        return values()[random.nextInt(Direction.values().length)];
    }
}
