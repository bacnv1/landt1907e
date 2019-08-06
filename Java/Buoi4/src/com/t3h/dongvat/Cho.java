package com.t3h.dongvat;

public class Cho extends DongVat{
    private boolean domDuoi;
    private boolean huyenDe;

    public Cho(String ten, int tuoi, boolean gioiTinh, String loai, boolean domDuoi, boolean huyenDe) {
        super(ten, tuoi, gioiTinh, loai);
        this.domDuoi = domDuoi;
        this.huyenDe = huyenDe;
    }

    public void coiNha() {
        System.out.println("Sua coi nha");
    }

    public void boi() {
        System.out.println("Biet boi");
    }

    @Override
    public void inThongTin() {
        super.inThongTin();
        System.out.println("Dom duoi: " + (domDuoi == true ? "Co" : "Khong"));
        System.out.println("Huyen de: " + (huyenDe == true ? "Co" : "Khong"));

    }
}
