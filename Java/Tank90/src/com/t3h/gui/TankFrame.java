package com.t3h.gui;

import javax.swing.*;
import java.awt.*;

public class TankFrame extends JFrame {
    public static final int W_FRAME = 510;
    public static final int H_FRAME = 530;

    public TankFrame() {
        setTitle("Tank 90");
        setSize(W_FRAME, H_FRAME);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        TankPanel panel = new TankPanel();
        add(panel);
    }
}
