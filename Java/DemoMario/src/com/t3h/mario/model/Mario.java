package com.t3h.mario.model;

import com.t3h.mario.utils.ImageLoader;

import java.awt.*;
import java.util.ArrayList;

public class Mario {
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int UP = 2;
    public static final int JUMP_LEFT = 3;
    public static final int JUMP_RIGHT = 4;
    private int x;
    private int y;
    private int orient;
    private int index;
    private int count;
    private int jump;
    private boolean isDown = true;

    private Image[] left = {
            ImageLoader.getImage("mario_move_left_1.png", getClass()),
            ImageLoader.getImage("mario_move_left_2.png", getClass()),
            ImageLoader.getImage("mario_move_left_3.png", getClass())
    };

    private Image[] right = {
            ImageLoader.getImage("mario_move_right_1.png", getClass()),
            ImageLoader.getImage("mario_move_right_2.png", getClass()),
            ImageLoader.getImage("mario_move_right_3.png", getClass())
    };

    private Image[] imJump = {
            ImageLoader.getImage("mario_jump.png", getClass()),
    };

    private Image[] imJumpLeft = {
            ImageLoader.getImage("mario_jump_left.png", getClass()),
    };

    private Image[] imJumpRight = {
            ImageLoader.getImage("mario_jump_right.png", getClass()),
    };

    private Image[][] images = { left, right, imJump, imJumpLeft, imJumpRight };

    public Mario(int x, int y) {
        this.x = x;
        this.y = y;
        orient = RIGHT;
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(images[orient][index], x, y, null);
    }

    public void changeOrient(int newOrient) {
        if (newOrient != orient) {
            orient = newOrient;
            if (isDown == false) {
                if (orient == LEFT) {
                    orient = JUMP_LEFT;
                }else if (orient == RIGHT) {
                    orient = JUMP_RIGHT;
                }else {
                    orient = UP;
                }
            }
            index = 0;
        }
    }

    public void changeImage() {
        count++;
        if (count >= 15) {
            index++;
            if (index >= images[orient].length) {
                index = 0;
            }
            count = 0;
        }
    }

    public void jump(ArrayList<Map> arrMap) {
        boolean check = checkMap(arrMap, getBottomRect());
        if (check == false) {
            jump = 100;
        }
    }

    public void fall(ArrayList<Map> arrMap) {
        boolean check = checkMap(arrMap, getBottomRect());
        if (check && jump == 0) {
            y++;
            isDown = false;
        }else if (jump > 0) {
            isDown = false;
            y-= 2;
            jump--;
        }else {
            isDown = true;
        }
    }

    public void move() {
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

    public boolean checkMap(ArrayList<Map> arr, Rectangle rect) {
        for (Map m: arr) {
            Rectangle r = m.getRect().intersection(rect);
            if (r.isEmpty() == false) {
                return false;
            }
        }
        return true;
    }

    public Rectangle getBottomRect() {
        int w = images[orient][index].getWidth(null);
        int h = images[orient][index].getHeight(null);
        Rectangle rect = new Rectangle(
                x + 10,
                y + h - 1,
                w - 20,
                1);
        return rect;
    }

    public int getX() {
        return x;
    }
}
