package com.ask.game.objects;

import com.ask.game.constants.Direction;
import com.ask.game.dto.DataObjects;
import com.ask.game.dto.LinkedListNode;
import com.ask.game.dto.TimerInvoker;
import com.ask.game.util.CustomLinkedList;
import com.ask.game.util.GameUtil;
import com.ask.game.util.TimerInterval;

import java.awt.*;
import java.util.Optional;
import java.util.Random;
import java.util.Timer;

public class Snake extends Canvas implements TimerInvoker {
    private TimerInterval<Snake> timerInterval;
    private transient CustomLinkedList<LinkedListNode<DataObjects>> linkedList;
    private Integer defaultSnakeBox = 5;
    private Integer padding = 10;
    private GameUtil gameUtil;
    private Food food;

    public Snake() {
        this.gameUtil = new GameUtil();
        DataObjects dataObjects = this.gameUtil.getRandomPosition(1200,800);
        DataObjects snakeFood = this.gameUtil.getRandomPosition(1200,800);
        dataObjects.setDestinationX(snakeFood.getPositionX());
        dataObjects.setDestinationY(snakeFood.getPositionY());
        this.food = new Food(snakeFood);
        dataObjects.setDistance(dataObjects.getWidth() + padding);
        this.timerInterval = new TimerInterval(this);
        Timer timer = new Timer("");
        timer.scheduleAtFixedRate(timerInterval, 1000L, 1000L);
        LinkedListNode<DataObjects> dataObjectsLinkedListNode = new LinkedListNode<>();
        dataObjectsLinkedListNode.setData(dataObjects);
        linkedList = new CustomLinkedList<>(dataObjectsLinkedListNode);
        buildInitialSnake();
    }

    private void buildInitialSnake() {
        DataObjects dataObjects = this.linkedList.getHead().getData();
//        Direction direction = dataObjects.getDirection();
        int positionX = dataObjects.getPositionX();
        int positionY = dataObjects.getPositionY();
        for(int index = 0; index < defaultSnakeBox ; index++) {
//            DataObjects newObject = getDataObjectsClone(dataObjects);
//            if (newObject == null) {
//                return;
//            }
//            switch (direction) {
//                case DOWN:
//                    positionY = positionY - dataObjects.getHeight() - padding;
//                    break;
//                case UP:
//                    positionY = positionY + dataObjects.getHeight() + padding;
//                    break;
//                case LEFT:
//                    positionX = positionX + dataObjects.getWidth() + padding;
//                    break;
//                case RIGHT:
//                    positionX = positionX - dataObjects.getWidth() - padding;
//                    break;
//            }
//            newObject.setPositionY(positionY);
//            newObject.setPositionX(positionX);
            DataObjects newObject = this.insertNode(positionX, positionY, dataObjects);
            positionX = newObject.getPositionX();
            positionY = newObject.getPositionY();
            LinkedListNode<DataObjects> linkedListNode = new LinkedListNode();
            linkedListNode.setData(newObject);
            this.linkedList.insert(linkedListNode);
        }
//        System.out.println("done prepared");

    }

    public DataObjects insertNode(int positionX, int positionY, DataObjects dataObjects) {
        DataObjects newObject = getDataObjectsClone(dataObjects);
        Direction direction = dataObjects.getDirection();
        if (newObject == null) {
            return null;
        }
        switch (direction) {
            case DOWN:
                positionY = positionY - dataObjects.getHeight() - padding;
                break;
            case UP:
                positionY = positionY + dataObjects.getHeight() + padding;
                break;
            case LEFT:
                positionX = positionX + dataObjects.getWidth() + padding;
                break;
            case RIGHT:
                positionX = positionX - dataObjects.getWidth() - padding;
                break;
        }
        newObject.setPositionY(positionY);
        newObject.setPositionX(positionX);
        return newObject;
    }

    @Override
    public void paint(Graphics graphics) {
        this.food.paint(graphics);
        this.linkedList.reset();
        DataObjects headNode = this.linkedList.getHead().getData();
        headNode.setColor(getRandomColor());
        paintSnake(graphics, headNode);
        while (this.linkedList.hasNext()) {
            DataObjects dataObjects = getNodeData();
            paintSnake(graphics, dataObjects);
        }


    }

    private Color getRandomColor() {
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255) , random.nextInt(255));
    }

    private void paintSnake(Graphics graphics, DataObjects dataObjects) {
        graphics.setColor(dataObjects.getColor());
        graphics.fillRoundRect(dataObjects.getPositionX(),dataObjects.getPositionY(),
                dataObjects.getWidth(), dataObjects.getHeight(), 25,25);
    }

    /**
     *
     */
    public void moveLeft() {
        DataObjects dataTempObjects = (DataObjects) Optional.ofNullable(this.linkedList).map(CustomLinkedList::getHead).map(LinkedListNode::getData).orElse(null);
        if (dataTempObjects != null) {
            int positionX = dataTempObjects.getPositionX();
            int positionY = dataTempObjects.getPositionY();
            positionX = positionX - dataTempObjects.getDistance();
            if (positionX <= 0) {
                this.moveRight();
                return;
            }
            this.syncLocation(positionX, positionY, Direction.LEFT);
        }
    }

    /**
     *
     * @param x
     * @param y
     * @param direction
     */
    private void syncLocation(int x, int y, Direction direction) {
        this.linkedList.reset();
        flowDataDown(x, y, direction);
//        setLocation(x, y);
        repaint();
    }

    /**
     *
     *
     * @param positionX
     * @param positionY
     * @param direction
     */
    private void flowDataDown(int positionX, int positionY, Direction direction) {
        DataObjects headObject = this.linkedList.getHead().getData();
        DataObjects tempObject = getDataObjectsClone(headObject);
        int destinationX = headObject.getDestinationX();
        int destinationY = headObject.getDestinationY();
        int width = headObject.getWidth();
        int height = headObject.getHeight();

        if (validateOverlap(positionX, positionY, destinationX, destinationY, width, height)) {
            DataObjects newData = insertNode(this.linkedList.getTail().getData().getPositionX(), this.linkedList.getTail().getData().getPositionY(), this.linkedList.getTail().getData());
            LinkedListNode<DataObjects> linkedListNode = new LinkedListNode();
            linkedListNode.setData(newData);
            this.linkedList.insert(linkedListNode);
            this.food.beep();
            headObject.setDestinationX(this.food.getDataObjects().getPositionX());
            headObject.setDestinationY(this.food.getDataObjects().getPositionY());
        }
        headObject.setPositionX(positionX);
        headObject.setPositionY(positionY);
        headObject.setDirection(direction);
        this.linkedList.getHead().setData(headObject);
        this.linkedList.reset();
        while (this.linkedList.hasNext()) {
            LinkedListNode<DataObjects> tempNode = this.linkedList.next();
            DataObjects copyObject = tempNode.getData();
            tempNode.setData(tempObject);
            tempObject = copyObject;
        }
        this.linkedList.reset();
    }

    private boolean validateOverlap(int positionX, int positionY, int destinationX, int destinationY, int width, int height) {
        return (destinationX >= positionX - width &&  destinationX <= (positionX + width))
                && (destinationY >= positionY - height && ( destinationY <=  positionY + height));
    }

    private DataObjects getDataObjectsClone(DataObjects headObject) {
        try {
            return headObject.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    private DataObjects getNodeData() {
        return Optional.ofNullable(this.linkedList).map(CustomLinkedList::next).map(LinkedListNode::getData).orElse(null);
    }

    /**
     *
     */
    public void moveRight() {
        DataObjects dataObjects = this.linkedList.getHead().getData();
        int x =  dataObjects.getPositionX();
        int y = dataObjects.getPositionY();
        x = x + dataObjects.getDistance();
        if (x >= dataObjects.getMaxWidth()) {
            this.moveLeft();
            return;
        }
        this.syncLocation(x, y, Direction.RIGHT);
    }

    /**
     *
     */
    public void moveUp(){
        DataObjects dataObjects = this.linkedList.getHead().getData();
        int x =  dataObjects.getPositionX();
        int y = dataObjects.getPositionY();
        y = y - dataObjects.getDistance();
        if (y <=0) {
            this.moveDown();
            return;
        }
        this.syncLocation(x, y, Direction.UP);
    }

    /**
     *
     */
    public void moveDown() {
        DataObjects dataObjects = this.linkedList.getHead().getData();
        int x =  dataObjects.getPositionX();
        int y = dataObjects.getPositionY();
        y = y + dataObjects.getDistance();
        if (y >= dataObjects.getMaxHeight()) {
            this.moveUp();
            return;
        }
        this.syncLocation(x, y, Direction.DOWN);
    }

    public void beep() {
        DataObjects dataObjects = this.linkedList.getHead().getData();
        switch (dataObjects.getDirection()) {
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
