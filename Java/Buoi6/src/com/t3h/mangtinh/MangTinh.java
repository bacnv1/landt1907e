package com.t3h.mangtinh;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class MangTinh {
    private Integer[] arr = new Integer[10];
    private Random rd = new Random();

    public MangTinh() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(100);
        }
    }

    public void inMang() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] +"\t");
        }
    }

    public void sapXep() {
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[i] < arr[j]) {
//                    int temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
        Arrays.sort(arr, comparator);
    }

    private Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    };
}
