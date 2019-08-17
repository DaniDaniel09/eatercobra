package com.ask.game.util;

import com.ask.game.constants.Direction;
import com.ask.game.dto.DataObjects;

import java.util.Random;

public class GameUtil {
    private static final Integer WIDTH_HEIGHT = 50;
    public DataObjects getRandomPosition(int width, int height) {
        Random random = new Random();
        DataObjects dataObjects = new DataObjects();
        dataObjects.setWidth(WIDTH_HEIGHT);
        dataObjects.setHeight(WIDTH_HEIGHT);
        dataObjects.setPositionX(random.nextInt(width - WIDTH_HEIGHT));
        dataObjects.setPositionY(random.nextInt(height - WIDTH_HEIGHT));
        dataObjects.setMaxWidth(width);
        dataObjects.setMaxHeight(height);
//        dataObjects.setDistance(DISTANCE);
        dataObjects.setDirection(Direction.getRandomDirection());
        return dataObjects;
    }
}
