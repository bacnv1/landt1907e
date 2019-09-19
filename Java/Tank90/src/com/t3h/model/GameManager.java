package com.t3h.model;

import com.t3h.gui.TankFrame;
import com.t3h.utils.SoundLoader;

import java.awt.*;
import java.util.ArrayList;

public class GameManager {
    private Player player;
    private ArrayList<Boss> arrBoss;
    private ArrayList<Bullet> arrBulletPlayer;
    private ArrayList<Bullet> arrBulletBoss;
    private ArrayList<Map> arrMap;

    public void initGame() {
        SoundLoader.play("enter_game.wav");
        arrMap = MapManager.readMap("map1.txt");
        arrBulletBoss = new ArrayList<>();
        arrBulletPlayer = new ArrayList<>();

        player = new Player(170, 460, 3);
        arrBoss = new ArrayList<>();
        generateBoss();
    }

    private void generateBoss() {
        Boss boss = new Boss(0, 0);
        arrBoss.add(boss);
        Boss boss1 = new Boss(TankFrame.W_FRAME/2 - 25, 0);
        arrBoss.add(boss1);
        Boss boss2 = new Boss(TankFrame.W_FRAME - 50, 0);
        arrBoss.add(boss2);
    }

    public void draw(Graphics2D g2d) {
        drawBullet(g2d, arrBulletBoss);
        drawBullet(g2d, arrBulletPlayer);
        player.draw(g2d);
        for (Boss b: arrBoss) {
            b.draw(g2d);
        }
        for (Map m: arrMap) {
            m.draw(g2d);
        }
    }

    private void drawBullet(Graphics2D g2d, ArrayList<Bullet> arr) {
        for (Bullet b: arr) {
            b.draw(g2d);
        }
    }

    public void playerMove(int newOrient) {
        player.changeOrient(newOrient);
        player.move(arrMap);
    }

    public void playerFire() {
        player.fire(arrBulletPlayer);
    }

    private boolean checkBulletToMap(ArrayList<Bullet> arr) {
        for (int i = arrMap.size() - 1; i >= 0; i--) {
            int bit = arrMap.get(i).getBit();
            if (bit == 4 || bit == 5) {
                continue;
            }
            for (int j = 0; j < arr.size(); j++) {
                Rectangle rect = arrMap.get(i).getRect()
                        .intersection(arr.get(j).getRect());
                if (rect.isEmpty() == false) {
                    SoundLoader.play("explosion.wav");
                    switch (bit){
                        case 1:
                            arrMap.remove(i);
                            arr.remove(j);
                            break;
                        case 2:
                            arr.remove(j);
                            break;
                        case 3:
                            arr.remove(j);
                            return true;
                    }
                    break;
                }
            }
        }
        return false;
    }

    public boolean AI() {
        for (int i = arrBoss.size() - 1; i >= 0; i--) {
            arrBoss.get(i).generateOrient();
            arrBoss.get(i).move(arrMap);
            arrBoss.get(i).fire(arrBulletBoss);
            boolean die = arrBoss.get(i).checkDie(arrBulletPlayer);
            if (die) {
                arrBoss.remove(i);
                if (arrBoss.size() <= 2){
                    generateBoss();
                }
            }
        }
        moveBullet(arrBulletPlayer);
        moveBullet(arrBulletBoss);

        return player.checkDie(arrBulletBoss)
                || checkBulletToMap(arrBulletBoss)
                || checkBulletToMap(arrBulletPlayer);
    }

    private void moveBullet(ArrayList<Bullet> arr) {
        for (int i = arr.size() - 1; i >= 0; i--) {
            boolean move = arr.get(i).move();
            if (move == false) {
                arr.remove(i);
            }
        }
    }
}
