package com.t3h.hinhhoc;

public class HinhChuNhat extends HinhHoc{
    private float chieuRong;
    private float chieuDai;

    public HinhChuNhat(String tenHinh, float chieuRong, float chieuDai) {
        super(tenHinh);
        this.chieuRong = chieuRong;
        this.chieuDai = chieuDai;
    }

    public void bienHinh() {
        System.out.println("Bien thanh hinh vuong");
    }

    @Override
    public void tinhChuVi() {
        float cv = 2 * (chieuDai + chieuRong);
        System.out.println("Chu vi: " + cv);
    }

    @Override
    public void tinhDienTich() {
        float dt = chieuDai * chieuRong;
        System.out.println("Dien Tich: " + dt);
    }

    @Override
    public void inThongTin() {
        super.inThongTin();
        System.out.println("Chieu dai: " + chieuDai);
        System.out.println("Chieu rong: " + chieuRong);
    }
}
