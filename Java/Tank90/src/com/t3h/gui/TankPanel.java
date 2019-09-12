package com.t3h.gui;

import com.t3h.model.GameManager;
import com.t3h.model.Tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TankPanel extends JPanel implements KeyListener {
    private GameManager manager = new GameManager();

    public TankPanel() {
        setBackground(Color.BLACK);
        manager.initGame();
        setFocusable(true);
        addKeyListener(this);
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
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                manager.playerMove(Tank.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                manager.playerMove(Tank.RIGHT);
                break;
            case KeyEvent.VK_UP:
                manager.playerMove(Tank.UP);
                break;
            case KeyEvent.VK_DOWN:
                manager.playerMove(Tank.DOWN);
                break;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
