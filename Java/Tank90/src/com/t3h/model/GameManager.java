package com.t3h.model;

import com.t3h.gui.TankFrame;

import java.awt.*;
import java.util.ArrayList;

public class GameManager {
    private Player player;
    private ArrayList<Boss> arrBoss;
    private ArrayList<Bullet> arrBulletPlayer;
    private ArrayList<Bullet> arrBulletBoss;

    public void initGame() {
        arrBulletBoss = new ArrayList<>();
        arrBulletPlayer = new ArrayList<>();

        player = new Player(200, 200, 3);
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
    }

    private void drawBullet(Graphics2D g2d, ArrayList<Bullet> arr) {
        for (Bullet b: arr) {
            b.draw(g2d);
        }
    }

    public void playerMove(int newOrient) {
        player.changeOrient(newOrient);
        player.move();
    }

    public void playerFire() {
        player.fire(arrBulletPlayer);
    }

    public boolean AI() {
        for (int i = arrBoss.size() - 1; i >= 0; i--) {
            arrBoss.get(i).generateOrient();
            arrBoss.get(i).move();
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
        return player.checkDie(arrBulletBoss);
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
