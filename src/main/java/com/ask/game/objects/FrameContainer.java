package com.ask.game.objects;

import com.ask.game.Application;
import com.ask.game.constants.Direction;
import com.ask.game.dto.DataObjects;
import com.ask.game.util.GameUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 *
 * @author Daniel/DaniDaniel09
 */
public class FrameContainer extends JFrame implements KeyListener {
    private static final Integer MAX_WIDTH = 1200;
    private static final Integer MAX_HEIGHT = 800;
//    private static final Integer DISTANCE = 50;
    private Snake snake;
//    private GameUtil gameUtil;
    private Food food;

    /**
     *
     */
    public FrameContainer() {
        super();
    }

    /**
     *
     */
    public void placeObject() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(0, 0, MAX_WIDTH, MAX_HEIGHT);
        Application application = new Application();

        this.snake = new Snake();
//        JPanel panel1 = new JPanel();
////        panel1.add(food);
//
////        JPanel panel2 = new JPanel();
////        panel2.add(snake);
////        this.setLayout(new FlowLayout());
//        this.getContentPane().add(panel1);
////        this.getContentPane().add(panel2);
//        panel1.add(snake);
////        panel1.add(food);
//        this.setLayout(new BorderLayout());
//        this.getContentPane().add(snake, BorderLayout.NORTH);
//        this.getContentPane().add(food, BorderLayout.SOUTH);
        this.add(snake);
        this.show();

        this.requestFocus();
        this.addKeyListener(this);
    }

//    public DataObjects getRandomPosition() {
//        Random random = new Random();
//        DataObjects dataObjects = new DataObjects();
//        dataObjects.setWidth(50);
//        dataObjects.setHeight(50);
//        dataObjects.setPositionX(random.nextInt(this.getWidth() - 50));
//        dataObjects.setPositionY(random.nextInt(this.getHeight() - 50));
//        dataObjects.setMaxWidth(this.getWidth());
//        dataObjects.setMaxHeight(this.getHeight());
////        dataObjects.setDistance(DISTANCE);
//        dataObjects.setDirection(Direction.getRandomDirection());
//        return dataObjects;
//    }

    /**
     *
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("typed" + e.getKeyCode());
    }

    /**
     *
     * @param e
     */
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

    /**
     *
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }
}
