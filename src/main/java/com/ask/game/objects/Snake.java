package com.ask.game.objects;

import com.ask.game.dto.DataObjects;

import java.awt.*;

public class Snake extends Canvas {
    private DataObjects dataObjects;

    public Snake(DataObjects dataObjects) {
        this.dataObjects = dataObjects;
        this.dataObjects.setWidth(50);
        this.dataObjects.setHeight(50);
    }

    public void paint(Graphics graphics) {
        graphics.setColor(Color.BLUE);
        graphics.fillOval(this.dataObjects.getPositionX(),this.dataObjects.getPositionY(),
                this.dataObjects.getWidth(), this.dataObjects.getHeight());

    }

    /**
     *
     */
    public void moveLeft() {
        int x =  this.dataObjects.getPositionX();
        int y = this.dataObjects.getPositionY();
        x = x -1;
        if (x <=0) {
            moveRight();
            return;
        }
        move(x,y);
    }

    /**
     *
     */
    public void moveRight() {
        int x =  this.dataObjects.getPositionX();
        int y = this.dataObjects.getPositionY();
        x = x+1;
        if (x >= dataObjects.getMaxWidth()) {
            moveLeft();
            return;
        }
        move(x,y);
    }

    /**
     *
     */
    public void moveUp(){
        int x =  this.dataObjects.getPositionX();
        int y = this.dataObjects.getPositionY();
        y = y+1;
        if (y <=0) {
            moveDown();
            return;
        }
        move(x,y);
    }

    /**
     *
     */
    public void moveDown() {
        int x =  this.dataObjects.getPositionX();
        int y = this.dataObjects.getPositionY();
        y = y +1;
        if (y >= dataObjects.getHeight()) {
            moveUp();
            return;
        }
        move(x,y);
    }
}
