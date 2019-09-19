package com.t3h.mario.model;


import com.t3h.mario.utils.ImageLoader;

import java.awt.*;

public class Map {
    private int x;
    private int y;
    private int bit;

    private Image[] images = {
            ImageLoader.getImage("floor2.png", getClass())
    };

    public Map(int x, int y, int bit) {
        this.x = x;
        this.y = y;
        this.bit = bit;
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(images[bit - 1], x, y, null);
    }

    public int getBit() {
        return bit;
    }

    public Rectangle getRect() {
        int w = images[bit - 1].getWidth(null);
        int h = images[bit - 1].getHeight(null);
        return new Rectangle(x, y, w, h);
    }

    public void move(int orient) {
        switch (orient) {
            case Mario.LEFT:
            case Mario.JUMP_LEFT:
                x--;
                break;
            case Mario.RIGHT:
            case Mario.JUMP_RIGHT:
                x++;
                break;
        }
    }

    public int getX() {
        return x;
    }
}
