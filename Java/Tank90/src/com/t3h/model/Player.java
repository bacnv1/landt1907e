package com.t3h.model;

import com.t3h.utils.ImageLoader;

import java.awt.*;

public class Player extends Tank {
    private int hp;

    public Player(int x, int y, int hp) {
        super(x, y, UP);
        this.hp = hp;
        images = new Image[4];
        images[LEFT] = ImageLoader.getImage("player_green_left.png", getClass());
        images[RIGHT] = ImageLoader.getImage("player_green_right.png", getClass());
        images[UP] = ImageLoader.getImage("player_green_up.png", getClass());
        images[DOWN] = ImageLoader.getImage("player_green_down.png", getClass());
    }

    public void changeOrient(int newOrient) {
        this.orient = newOrient;
    }
}
