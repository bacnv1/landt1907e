package com.t3h.main;

import com.t3h.hinhhoc.HinhChuNhat;
import com.t3h.hinhhoc.HinhHoc;
import com.t3h.hinhhoc.HinhTron;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        HinhTron ht = new HinhTron("Hinh Tron", 5f);
//        ht.inThongTin();
//        ht.tinhChuVi();
//        ht.tinhDienTich();
//        System.out.println("==================");
//        HinhChuNhat hcn = new HinhChuNhat("Hinh Chu Nhat",
//                3, 5);
//        hcn.inThongTin();
//        hcn.tinhChuVi();
//        hcn.tinhDienTich();

//        Random rd = new Random();
////        boolean v = rd.nextBoolean();
////        HinhHoc hinhHoc;
////        if (v == true) {
////            hinhHoc = new HinhTron("Hinh tron", 5f);
////        }else {
////            hinhHoc = new HinhChuNhat("Hinh CN",
////                    4, 5);
////        }
////        hinhHoc.inThongTin();
////        hinhHoc.tinhChuVi();
////        hinhHoc.tinhDienTich();
////        // ep kieu
////        boolean check = hinhHoc instanceof HinhTron;
////        if (check == true) {
////            HinhTron ht = (HinhTron) hinhHoc;
////            ht.xoayTron();
////        }else {
////            HinhChuNhat hcn = (HinhChuNhat) hinhHoc;
////            hcn.bienHinh();
////        }

        int a = 3;

        HinhTron ht = new HinhTron("Hinh Tron", 5f);
        ht.inThongTin();
        ht.tinhDienTich();
        ht.tinhChuVi();
        System.out.println("===================");
        changeValue(a, ht);
        System.out.println("gia tri a: " + a);
        ht.inThongTin();
        ht.tinhDienTich();
        ht.tinhChuVi();
    }
    private static void changeValue(int a, HinhTron ht) {
        a = 4;
        ht.setBanKinh(10);
    }
}

