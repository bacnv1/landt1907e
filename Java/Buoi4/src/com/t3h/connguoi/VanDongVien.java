package com.t3h.connguoi;

import com.t3h.dongvat.Cho;

public class VanDongVien extends ConNguoi{
    private int soAo;
    private String cauLacBo;
    private String viTri;
    private Cho cho;

    public VanDongVien(String ten, int tuoi, boolean gioiTinh, String diaChi, int soAo, String cauLacBo, String viTri, Cho cho) {
        super(ten, tuoi, gioiTinh, diaChi);
        this.soAo = soAo;
        this.cauLacBo = cauLacBo;
        this.viTri = viTri;
        this.cho = cho;
    }

    public void datChoDiDao() {
        System.out.println("Dat cho di dao o cong vien");
    }

    @Override
    public void inThongTin() {
        super.inThongTin();
        System.out.println("So ao: " + soAo);
        System.out.println("Cau lac bo: " + cauLacBo);
        System.out.println("Vi tri: " + viTri);
        System.out.println("==Thong tin thu cung==");
        cho.inThongTin();
        cho.coiNha();
        cho.boi();
    }
}
