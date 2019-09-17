package com.t3h.model;

import com.t3h.utils.ImageLoader;

import java.awt.*;

public class Map {
    private int x;
    private int y;
    private int bit;

    private Image[] images = {
            ImageLoader.getImage("brick.png", getClass()),
            ImageLoader.getImage("rock.png", getClass()),
            ImageLoader.getImage("bird.png", getClass()),
            ImageLoader.getImage("tree.png", getClass()),
            ImageLoader.getImage("water.png", getClass())
    };

    public Map(int x, int y, int bit) {
        this.x = x;
        this.y = y;
        this.bit = bit;
    }

    public void draw(Graphics2D g2d) {
        if (bit == 3) {
            g2d.drawImage(images[bit - 1], x, y,
                    38, 38, null);
            return;
        }
        g2d.drawImage(images[bit - 1], x, y, null);
    }

    public int getBit() {
        return bit;
    }

    public Rectangle getRect() {
        int w = images[bit - 1].getWidth(null);
        int h = images[bit - 1].getHeight(null);
        if (bit == 3){
            w = 38;
            h = 38;
        }
        return new Rectangle(x, y, w, h);
    }
}
