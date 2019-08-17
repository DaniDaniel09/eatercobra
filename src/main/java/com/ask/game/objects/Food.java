package com.ask.game.objects;

import com.ask.game.dto.DataObjects;
import com.ask.game.dto.TimerInvoker;
import com.ask.game.util.GameUtil;

import java.awt.*;

public class Food extends Canvas implements TimerInvoker {
    private  DataObjects dataObjects;
    private GameUtil gameUtil;
    public Food(DataObjects dataObjects) {
        this.dataObjects = dataObjects;
        this.gameUtil = new GameUtil();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.setColor(dataObjects.getColor());
        graphics.fillRoundRect(dataObjects.getPositionX(),dataObjects.getPositionY(),
                dataObjects.getWidth(), dataObjects.getHeight(), 25,25);
    }

    public DataObjects getDataObjects() {
        return this.dataObjects;
    }

    @Override
    public void beep() {
        this.dataObjects = this.gameUtil.getRandomPosition(dataObjects.getMaxWidth(), dataObjects.getMaxHeight());

    }
}
