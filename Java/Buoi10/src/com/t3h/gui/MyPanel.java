package com.t3h.gui;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    public MyPanel() {
        setLayout(null);
        setBackground(Color.BLACK);

        PanelGame game = new PanelGame();
        PanelMenu menu = new PanelMenu();
        add(game);
        add(menu);
    }
}
