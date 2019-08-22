package com.t3h.lophoc;

public class SinhVien {
    private String maSv;
    private String hoTen;
    private boolean gioiTinh;
    private String diaChi;
    private float diem;

    public SinhVien(String maSv, String hoTen, boolean gioiTinh, String diaChi, float diem) {
        this.maSv = maSv;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.diem = diem;
    }

    public String getMaSv() {
        return maSv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public float getDiem() {
        return diem;
    }

    public void inThongTin() {
        System.out.println("Mã sinh viên : " + maSv);
        System.out.println("Họ tên : " + hoTen);
        System.out.println("Giới tính : " + gioiTinh);
        System.out.println("Địa chỉ : " + diaChi);
        System.out.println("Điểm : " + diem);
    }
}
