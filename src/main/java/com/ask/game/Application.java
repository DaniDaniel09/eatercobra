package com.ask.game;

import com.ask.game.objects.FrameContainer;
import com.ask.game.objects.Snake;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Application {

    Snake snake = null;

    /**
     *
     * @param args
     * @author Daniel/DaniDaniel09
     */
    public static void main(String[] args) {
        FrameContainer frameContainer = new FrameContainer();
        frameContainer.placeObject();
    }

}