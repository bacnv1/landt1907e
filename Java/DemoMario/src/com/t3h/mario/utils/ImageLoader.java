package com.t3h.mario.utils;

import javax.swing.*;
import java.awt.*;

public class ImageLoader {
    public static Image getImage(String name, Class clz) {
        return new ImageIcon(clz.getResource("/image/" + name)).getImage();
    }
}
