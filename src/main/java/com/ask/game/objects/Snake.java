package com.ask.game.objects;

import com.ask.game.constants.Directions;
import com.ask.game.dto.DataObjects;
import com.ask.game.dto.TimerInvoker;
import com.ask.game.util.TimerInterval;

import java.awt.*;
import java.util.Random;
import java.util.Timer;

public class Snake extends Canvas implements TimerInvoker {
    private DataObjects dataObjects;
    private TimerInterval<Snake> timerInterval;

    public Snake(DataObjects dataObjects) {
        this.dataObjects = dataObjects;
        this.timerInterval = new TimerInterval(this);
        Timer timer = new Timer("");
        timer.scheduleAtFixedRate(timerInterval, 1000L, 100L);
    }

    @Override
    public void paint(Graphics graphics) {
        Random random = new Random();
        Color color = new Color(random.nextInt(255), random.nextInt(255) , random.nextInt(255));
        graphics.setColor(color);
        graphics.fillRoundRect(this.dataObjects.getPositionX(),this.dataObjects.getPositionY(),
                this.dataObjects.getWidth(), this.dataObjects.getHeight(), 25,25);

    }

    /**
     *
     */
    public void moveLeft() {
        int x =  this.dataObjects.getPositionX();
        int y = this.dataObjects.getPositionY();
        x = x - this.dataObjects.getSpeed();
        if (x <=0) {
            this.moveRight();
            return;
        }
        this.syncLocation(x, y);
        this.dataObjects.setDirections(Directions.LEFT);
    }

    private void syncLocation(int x, int y) {
//        System.out.println(x + "y " + y);
        this.dataObjects.setPositionX(x);
        this.dataObjects.setPositionY(y);
        setLocation(x, y);
    }

    /**
     *
     */
    public void moveRight() {
        int x =  this.dataObjects.getPositionX();
        int y = this.dataObjects.getPositionY();
        x = x + this.dataObjects.getSpeed();
        if (x >= dataObjects.getMaxWidth()) {
            this.moveLeft();
            return;
        }
        this.syncLocation(x, y);
        this.dataObjects.setDirections(Directions.RIGHT);
    }

    /**
     *
     */
    public void moveUp(){
        int x =  this.dataObjects.getPositionX();
        int y = this.dataObjects.getPositionY();
        y = y - this.dataObjects.getSpeed();
        if (y <=0) {
            this.moveDown();
            return;
        }
        this.syncLocation(x, y);
        this.dataObjects.setDirections(Directions.UP);
    }

    /**
     *
     */
    public void moveDown() {
        int x =  this.dataObjects.getPositionX();
        int y = this.dataObjects.getPositionY();
        y = y + this.dataObjects.getSpeed();
        if (y >= dataObjects.getMaxHeight()) {
            this.moveUp();
            return;
        }
        this.syncLocation(x, y);
        this.dataObjects.setDirections(Directions.DOWN);
    }

    public void beep() {
        switch (dataObjects.getDirections()) {
            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
            case RIGHT:
                moveRight();
                break;
            case LEFT:
                moveLeft();
                break;


        }
        repaint();
    }
}
