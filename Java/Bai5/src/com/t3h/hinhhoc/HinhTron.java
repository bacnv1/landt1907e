package com.t3h.hinhhoc;

public class HinhTron extends HinhHoc{
    private float banKinh;
    private final float PI = 3.14f;

    public HinhTron(String tenHinh, float banKinh) {
        super(tenHinh);
        this.banKinh = banKinh;
    }

    public void xoayTron(){
        System.out.println("Xoay tron");
    }

    @Override
    public void tinhChuVi() {
        float chuVi = 2 * PI * banKinh;
        System.out.println("Chu vi la: " + chuVi);
    }

    @Override
    public void tinhDienTich() {
        float dienTich = PI * banKinh * banKinh;
        System.out.println("Dien tich la: " + dienTich);
    }

    @Override
    public void inThongTin() {
        super.inThongTin();
        System.out.println("Ban Kinh: "+ banKinh);
    }

    public void setBanKinh(float banKinh) {
        this.banKinh = banKinh;
    }
}
