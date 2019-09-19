package com.t3h.model;

import com.t3h.gui.TankFrame;
import com.t3h.utils.SoundLoader;

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

    private boolean checkMap(ArrayList<Map> arr) {
        for (Map m: arr) {
            if (m.getBit() == 4) {
                continue;
            }
            Rectangle rect = getRect()
                    .intersection(m.getRect());
            if (rect.isEmpty() == false) {
                return false;
            }
        }
        return true;
    }

    public void move(ArrayList<Map> arr) {
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
                images[orient].getHeight(null) - 37) {
            y = yR;
        }
        if (checkMap(arr) == false) {
            x = xR;
            y = yR;
        }
    }

    private long t;
    public void fire(ArrayList<Bullet> arr) {
        long T = System.currentTimeMillis();
        if (T - t < 500) {
            return;
        }
        if (this instanceof Player) {
            SoundLoader.play("shoot.wav");
        }
        t = T;
        int xB = x + images[orient].getWidth(null) / 2;
        int yB = y + images[orient].getHeight(null) / 2;
        Bullet b = new Bullet(xB, yB, orient);
        arr.add(b);
    }

    public Rectangle getRect() {
        int w = images[orient].getWidth(null);
        int h = images[orient].getHeight(null);
        if (orient == UP || orient == DOWN) {
            w -=  1;
        }else {
            h -= 2;
        }
        Rectangle rect = new Rectangle(x, y, w, h);
        return rect;
    }

    public boolean checkDie(ArrayList<Bullet> arr) {
        for (int i = 0; i < arr.size(); i++) {
            Rectangle rect = getRect()
                    .intersection(arr.get(i).getRect());
            if (rect.isEmpty() == false) {
                arr.remove(i);
                SoundLoader.play("explosion_tank.wav");
                return true;
            }
        }
        return false;
    }
}
