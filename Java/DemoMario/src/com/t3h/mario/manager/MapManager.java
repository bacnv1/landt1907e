package com.t3h.mario.manager;

import com.t3h.mario.model.Map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class MapManager {
    public static ArrayList<Map> readMap(String name) {
        ArrayList<Map> arr = new ArrayList<>();
        try {
            File file = new File("src/maps/" + name);
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            int i = 0;
            String line = reader.readLine();
            while (line != null) {
                for (int j = 0; j < line.length(); j++) {
                    String s = line.charAt(j) + "";
                    if (s.trim().isEmpty() == false) {
                        int bit = Integer.parseInt(s);
                        int x = j * 64;
                        int y = i * 59;
                        Map m = new Map(x, y, bit);
                        arr.add(m);
                    }
                }
                i++;
                line = reader.readLine();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return arr;
    }
}
