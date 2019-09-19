package com.t3h.gui;

import com.t3h.model.GameManager;
import com.t3h.model.Tank;
import com.t3h.utils.SoundLoader;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TankPanel extends JPanel implements KeyListener, Runnable {
    private GameManager manager = new GameManager();
    private boolean[] flags = new boolean[256];
    private Clip clip;

    public TankPanel() {
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
        flags[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        flags[e.getKeyCode()] = false;
    }

    private void checkSoundMove() {
        if (flags[KeyEvent.VK_LEFT]
                || flags[KeyEvent.VK_RIGHT]
                || flags[KeyEvent.VK_UP]
                || flags[KeyEvent.VK_DOWN]) {
            if (clip == null) {
                clip = SoundLoader.play("move.wav");
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
        }else {
            if (clip != null) {
                clip.stop();
                clip = null;
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            if (flags[KeyEvent.VK_LEFT]) {
                manager.playerMove(Tank.LEFT);
            } else if (flags[KeyEvent.VK_RIGHT]) {
                manager.playerMove(Tank.RIGHT);
            } else if (flags[KeyEvent.VK_UP]) {
                manager.playerMove(Tank.UP);
            } else if (flags[KeyEvent.VK_DOWN]) {
                manager.playerMove(Tank.DOWN);
            }
            if (flags[KeyEvent.VK_SPACE]) {
                manager.playerFire();
            }
            checkSoundMove();
            boolean isDie = manager.AI();
            if (isDie) {
                int result = JOptionPane.showConfirmDialog(
                        null,
                        "Do you wan to replay",
                        "Game over",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    flags = new boolean[256];
                    manager.initGame();
                }else {
                    System.exit(0);
                }
            }
            repaint();
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
