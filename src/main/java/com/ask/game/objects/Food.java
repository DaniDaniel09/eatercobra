package com.ask.game.objects;

import com.ask.game.dto.DataObjects;
import com.ask.game.dto.TimerInvoker;
import com.ask.game.util.GameUtil;

import java.awt.*;

/**
 *
 * @author Daniel/DaniDaniel09
 */
public class Food extends Canvas implements TimerInvoker {
    private  DataObjects dataObjects;
    private GameUtil gameUtil;

    /**
     *
     * @param dataObjects
     */
    public Food(DataObjects dataObjects) {
        this.dataObjects = dataObjects;
        this.gameUtil = new GameUtil();
    }

    /**
     *
     * @param graphics
     */
    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.setColor(dataObjects.getColor());
        graphics.fillRoundRect(dataObjects.getPositionX(),dataObjects.getPositionY(),
                dataObjects.getWidth(), dataObjects.getHeight(), 25,25);
    }

    /**
     *
     * @return
     */
    public DataObjects getDataObjects() {
        return this.dataObjects;
    }

    /**
     *
     */
    @Override
    public void beep() {
        this.dataObjects = this.gameUtil.getRandomPosition(dataObjects.getMaxWidth(), dataObjects.getMaxHeight());

    }
}
