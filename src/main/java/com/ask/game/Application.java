package com.ask.game;

import com.ask.game.objects.FrameContainer;
import com.ask.game.objects.Snake;

public class Application {

    Snake snake = null;


    public static void main(String[] args) {
        FrameContainer frameContainer = new FrameContainer();
        frameContainer.placeObject();

    }

}