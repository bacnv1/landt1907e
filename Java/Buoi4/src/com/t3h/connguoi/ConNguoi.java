package com.t3h.connguoi;

public class ConNguoi {
    protected String ten;
    protected int tuoi;
    protected boolean gioiTinh;
    protected String diaChi;

    public ConNguoi(String ten, int tuoi, boolean gioiTinh, String diaChi) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
    }

    public void inThongTin(){
        System.out.println("Ten: " + ten);
        System.out.println("Tuoi: " + tuoi);
        System.out.println("Gioi Tinh: " +
                (gioiTinh == true  ? "Nam" : "Nu"));
        System.out.println("Dia Chi: " + diaChi);
    }
}