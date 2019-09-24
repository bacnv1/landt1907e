package com.t3h.mario.gui;

import com.t3h.mario.manager.GameManager;
import com.t3h.mario.model.Mario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MarioPanel extends JPanel implements KeyListener, Runnable {
    private GameManager manager = new GameManager();
    private boolean[] flag = new boolean[256];

    public MarioPanel() {
        setBackground(Color.BLACK);
        manager.initGame();
        setFocusable(true);
        addKeyListener(this);
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        manager.draw(g2d);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        flag[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        flag[e.getKeyCode()] = false;
    }

    @Override
    public void run() {
        while (true) {
            if (flag[KeyEvent.VK_LEFT] && flag[KeyEvent.VK_UP]) {
                manager.playerMove(Mario.JUMP_LEFT);
            }else if (flag[KeyEvent.VK_RIGHT] && flag[KeyEvent.VK_UP]) {
                manager.playerMove(Mario.JUMP_RIGHT);
            }else if (flag[KeyEvent.VK_LEFT]) {
                manager.playerMove(Mario.LEFT);
            }else if (flag[KeyEvent.VK_RIGHT]) {
                manager.playerMove(Mario.RIGHT);
            }else if (flag[KeyEvent.VK_UP]) {
                manager.playerMove(Mario.UP);
            }
            if (flag[KeyEvent.VK_UP]) {
                manager.playerJump();
            }
            manager.AI();
            repaint();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
