package com.t3h.mario.gui;

import javax.swing.*;
import java.awt.*;

public class MarioFrame extends JFrame {
    public static final int W_FRAME = 800;
    public static final int H_FRAME = 600;

    public MarioFrame() {
        setTitle("Mario");
        setSize(W_FRAME, H_FRAME);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(new MarioPanel());
    }
}
