package com.t3h.lophoc;

import java.util.ArrayList;
import java.util.Comparator;

public class LopHoc {
    private ArrayList<SinhVien> sinhVienArrayList = new ArrayList<>();

    private int check(String maSinhVien) {
        for (int i = 0; i < sinhVienArrayList.size(); i++) {
            if (sinhVienArrayList.get(i).getMaSv().equals(maSinhVien)) {
                return i;
            }
        }
        return -1;
    }

    public void add(SinhVien sinhVien) {
        if (check(sinhVien.getMaSv()) == -1) {
            sinhVienArrayList.add(sinhVien);
        } else {
            System.out.println("Đã tồn tại sinh viên này");
        }
    }

    public void update(SinhVien sinhVien) {
        int index = check(sinhVien.getMaSv());
        if (index >= 0) {
            sinhVienArrayList.set(index, sinhVien);
        } else {
            System.out.println("Ko tồn tại sinh viên này");
        }
    }

    public void delete(String maSinhVien) {
        int index = check(maSinhVien);
        if (index >= 0) {
            sinhVienArrayList.remove(index);
        } else {
            System.out.println("Ko tồn tại sinh viên này");
        }
    }

    public void sort() {
        sinhVienArrayList.sort(comparator);
    }

    private Comparator<SinhVien> comparator = new Comparator<SinhVien>() {
        @Override
        public int compare(SinhVien o1, SinhVien o2) {
            if (o1.getDiem() > o2.getDiem()) {
                return 1;
            }
            return -1;
        }
    };

    public void print() {
        for (SinhVien sinhVien : sinhVienArrayList) {
            sinhVien.inThongTin();
            System.out.println("===================");
        }
    }
}
