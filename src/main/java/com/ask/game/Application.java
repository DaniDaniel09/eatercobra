package com.ask.game;

import com.ask.game.dto.DataObjects;
import com.ask.game.objects.Snake;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Application implements KeyListener {

    Snake snake = null;
    private static final Integer MAX_WIDTH = 500;
    private static final Integer MAX_HEIGHT = 500;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Local");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(0,0, MAX_WIDTH, MAX_HEIGHT);
        Application application = new Application();
        application.snake = new Snake(getRandomPosition());
        frame.add(application.snake);
//        frame.pack();
        frame.show();
    }

    public static DataObjects getRandomPosition() {
//        Random randomWidth = new Random();
        Random random = new Random();
        DataObjects dataObjects = new DataObjects();
        dataObjects.setWidth(random.nextInt(MAX_WIDTH));
        dataObjects.setHeight(random.nextInt(MAX_HEIGHT));
        dataObjects.setPositionX(random.nextInt(MAX_WIDTH));
        dataObjects.setPositionY(random.nextInt(MAX_HEIGHT));
        dataObjects.setMaxWidth(MAX_WIDTH);
        dataObjects.setHeight(MAX_HEIGHT);
        return dataObjects;
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.snake.moveLeft();

        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {

        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {

        }

    }

    public void keyReleased(KeyEvent e) {

    }
}
