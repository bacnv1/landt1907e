package com.t3h.model;

import com.t3h.utils.ImageLoader;

import java.awt.*;
import java.util.Random;

public class Boss extends Tank{

    private Random rd = new Random();

    public Boss(int x, int y) {
        super(x, y, DOWN);
        images = new Image[4];
        images[LEFT] = ImageLoader.getImage(
                "bossyellow_left.png", getClass());
        images[RIGHT] = ImageLoader.getImage(
                "bossyellow_right.png", getClass());
        images[UP] = ImageLoader.getImage(
                "bossyellow_up.png", getClass());
        images[DOWN] = ImageLoader.getImage(
                "bossyellow_down.png", getClass());
    }

    public void generateOrient(){
        int percent = rd.nextInt(101);
        if (percent <= 95){
            return;
        }
        int newOrient = rd.nextInt(4);
        orient = newOrient;
    }
}
