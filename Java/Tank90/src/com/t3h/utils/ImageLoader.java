package com.t3h.utils;

import javax.swing.*;
import java.awt.*;

public class ImageLoader {
    public static Image getImage(String name, Class clz) {
        Image im = new ImageIcon(
                clz.getResource("/images/" + name)
        ).getImage();
        return im;
    }
}
