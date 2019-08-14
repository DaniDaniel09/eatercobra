package com.ask.game.objects;

import com.ask.game.Application;
import com.ask.game.constants.Directions;
import com.ask.game.dto.DataObjects;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class FrameContainer extends JFrame implements KeyListener {
    private static final Integer MAX_WIDTH = 500;
    private static final Integer MAX_HEIGHT = 500;
    private static final Integer SPEED = 10;
    private Snake snake;

    public FrameContainer() {
        super();
    }

    public void placeObject() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(0, 0, MAX_WIDTH, MAX_HEIGHT);
        Application application = new Application();
        this.snake = new Snake(getRandomPosition());
        this.add(snake);
        this.show();
        this.requestFocus();
        this.addKeyListener(this);
    }

    public DataObjects getRandomPosition() {
        Random random = new Random();
        DataObjects dataObjects = new DataObjects();
        dataObjects.setWidth(50);
        dataObjects.setHeight(50);
        dataObjects.setPositionX(random.nextInt(this.getWidth() - 50));
        dataObjects.setPositionY(random.nextInt(this.getHeight() - 50));
        dataObjects.setMaxWidth(this.getWidth());
        dataObjects.setMaxHeight(this.getHeight());
        dataObjects.setSpeed(SPEED);
        dataObjects.setDirections(Directions.getRandomDirection());
        return dataObjects;
    }


    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("typed" + e.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("typed" + e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.snake.moveLeft();

        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.snake.moveRight();

        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.snake.moveUp();

        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.snake.moveDown();

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }
}
