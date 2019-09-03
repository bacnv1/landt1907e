package com.t3h.files;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class FileManager {
    public void getFile() {
        String path = "D:/T3H/LANDT1907E/Android/Java/Info.txt";
        File f = new File(path);
        boolean exists = f.exists();
        if (exists) {
            System.out.println(f.getName());
            System.out.println(f.length());
            long time = f.lastModified();
            System.out.println(time);
            SimpleDateFormat format =
                    new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
            System.out.println(format.format(time));
        }else {
            try {
                f.getParentFile().mkdirs();
                f.createNewFile();
                System.out.println("Create success");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
