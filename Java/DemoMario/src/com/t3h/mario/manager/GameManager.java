package com.t3h.mario.manager;

import com.t3h.mario.gui.MarioFrame;
import com.t3h.mario.model.Map;
import com.t3h.mario.model.Mario;

import java.awt.*;
import java.util.ArrayList;

public class GameManager {
    private Mario mario;
    private ArrayList<Map> arrMap;
    private int level = 1;
    public void initGame() {
        readMap();
        mario = new Mario(100, 300);
    }

    private void readMap() {
        arrMap = MapManager.readMap("map"+level+".txt");
    }

    public void draw(Graphics2D g2d) {
        for (Map map: arrMap) {
            map.draw(g2d);
        }
        mario.draw(g2d);
    }

    public void playerMove(int newOrient) {
        mario.changeOrient(newOrient);
        mario.changeImage();
        int xF = arrMap.get(0).getX();
        int xL = arrMap.get(arrMap.size() - 1).getX();
        if ((xF == 0 && (newOrient == Mario.LEFT || newOrient == Mario.JUMP_LEFT))
                || (xL == MarioFrame.W_FRAME && (newOrient == Mario.RIGHT || newOrient == Mario.JUMP_RIGHT))) {
            mario.move();
        }else {
            if (mario.getX() != MarioFrame.W_FRAME /2) {
                mario.move();
            }else {
                moveMap(newOrient);
            }
        }
    }

    public void moveMap(int newOrient) {
        for (Map m: arrMap) {
            if (newOrient == Mario.LEFT || newOrient == Mario.JUMP_LEFT) {
                m.move(Mario.RIGHT);
            }else if(newOrient == Mario.RIGHT || newOrient == Mario.JUMP_RIGHT) {
                m.move(Mario.LEFT);
            }
        }
    }

    public void playerJump() {
        mario.jump(arrMap);
    }

    public void AI() {
        if (mario.getX() >= MarioFrame.W_FRAME - 200) {
            mario = new Mario(100, 300);
            level++;
            readMap();
        }
        mario.fall(arrMap);
    }
}
