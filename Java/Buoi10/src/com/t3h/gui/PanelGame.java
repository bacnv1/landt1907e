package com.t3h.gui;

import javax.swing.*;
import java.awt.*;

public class PanelGame extends JPanel {
    public PanelGame() {
        setBackground(Color.BLUE);
        setBounds(MyFrame.W_FRAME/3, 0,
                MyFrame.W_FRAME/3 * 2, MyFrame.H_FRAME);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(30));
        g2d.drawLine(0, 0, 500, 5000);
        g2d.drawOval(200, 200, 100, 100);

        g2d.setFont(new Font("Algerian", Font.BOLD, 20));
        g2d.drawString("Hello world", 300, 100);
    }
}
