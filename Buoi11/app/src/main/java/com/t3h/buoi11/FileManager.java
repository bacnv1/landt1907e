package com.t3h.buoi11;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class FileManager {
    private String rootPath = Environment
            .getExternalStorageDirectory().getPath();

    public File[] getFiles(String path) {
        File f = new File(path);
        return f.listFiles();
    }

    public String download(String link) {
        try {
            String path = rootPath + "/Buoi11/"
                    + System.currentTimeMillis() + ".html";
            File f = new File(path);
            f.getParentFile().mkdirs();
            f.createNewFile();
            FileOutputStream out = new FileOutputStream(f);

            URL url = new URL(link);
            URLConnection connection = url.openConnection();
            InputStream in = connection.getInputStream();
            byte[] b = new byte[1024];
            int count = in.read(b);
            while (count > 0) {
                out.write(b, 0, count);
                count = in.read(b);
            }
            out.close();
            in.close();
            return path;
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String getRootPath() {
        return rootPath;
    }
}
