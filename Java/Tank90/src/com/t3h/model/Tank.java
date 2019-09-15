package com.t3h.model;

import com.t3h.gui.TankFrame;

import java.awt.*;
import java.util.ArrayList;

public abstract class Tank {
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int UP = 2;
    public static final int DOWN = 3;

    protected int x;
    protected int y;
    protected Image[] images;
    protected int orient;
    protected int speed = 1;

    public Tank(int x, int y, int orient) {
        this.x = x;
        this.y = y;
        this.orient = orient;
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(images[orient], x, y, null);
    }

    public void move() {
        int xR = x;
        int yR = y;
        switch (orient) {
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
        }
        if (x <= 0 || x >= TankFrame.W_FRAME -
                images[orient].getWidth(null) - 10) {
            x = xR;
        }
        if (y <= 0
                || y >= TankFrame.H_FRAME -
                images[orient].getHeight(null) - 30) {
            y = yR;
        }
    }

    private long t;
    public void fire(ArrayList<Bullet> arr) {
        long T = System.currentTimeMillis();
        if (T - t < 500) {
            return;
        }
        t = T;
        int xB = x + images[orient].getWidth(null) / 2;
        int yB = y + images[orient].getHeight(null) / 2;
        Bullet b = new Bullet(xB, yB, orient);
        arr.add(b);
    }

    public Rectangle getRect() {
        Rectangle rect = new Rectangle(x, y,
                images[orient].getWidth(null),
                images[orient].getHeight(null));
        return rect;
    }

    public boolean checkDie(ArrayList<Bullet> arr) {
        for (int i = 0; i < arr.size(); i++) {
            Rectangle rect = getRect()
                    .intersection(arr.get(i).getRect());
            if (rect.isEmpty() == false) {
                arr.remove(i);
                return true;
            }
        }
        return false;
    }
}
