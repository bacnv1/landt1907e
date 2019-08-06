package com.t3h.connguoi;

import com.t3h.dongvat.Meo;

public class NguoiMau extends ConNguoi{
    private String soDo3Vong;
    private String nhanHieu;
    private Meo meo;

    public NguoiMau(String ten, int tuoi, boolean gioiTinh, String diaChi, String soDo3Vong, String nhanHieu, Meo meo) {
        super(ten, tuoi, gioiTinh, diaChi);
        this.soDo3Vong = soDo3Vong;
        this.nhanHieu = nhanHieu;
        this.meo = meo;
    }

    public void datMeoDiShopping() {
        System.out.println("Dat meo di shopping");
    }

    @Override
    public void inThongTin() {
        super.inThongTin();
        System.out.println("So do 3 vong: " + soDo3Vong);
        System.out.println("Nhan hieu: " + nhanHieu);
        System.out.println("=Thu cung=");
        meo.inThongTin();
        meo.batChuot();
        meo.treoCay();
    }
}
