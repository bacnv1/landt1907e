package com.t3h.lophoc;

public class Main {
    public static void main(String[] args) {
        SinhVien sinhVien = new SinhVien("1", "Nguyễn Văn A", true, "HN", 5.5f);
        SinhVien sinhVien2 = new SinhVien("2", "Nguyễn Văn B", false, "HN", 7.5f);
        SinhVien sinhVien3 = new SinhVien("2", "Nguyễn Văn C", false, "HN", 6.5f);

        LopHoc lopHoc = new LopHoc();
        lopHoc.add(sinhVien);
        lopHoc.add(sinhVien2);
        lopHoc.add(sinhVien3);
        lopHoc.sort();
        lopHoc.print();

        lopHoc.update(sinhVien3);
//        lopHoc.delete("1");
//        lopHoc.print();
    }
}
