package com.t3h.main;

import com.t3h.connguoi.NguoiMau;
import com.t3h.connguoi.VanDongVien;
import com.t3h.dongvat.Cho;
import com.t3h.dongvat.Meo;

public class Main {
    public static void main(String[] args) {
        Cho cho = new Cho("Cucu", 3, true,
                "Cho nhat", true, false);
        Meo meo = new Meo("Kiki", 2, false,
                "Meo muop");
        VanDongVien vdv = new VanDongVien("Nguyen Van A",
                32, true, "Ha noi", 7,
                "Manchester United",
                "Trung ve chay canh",
                cho);
        NguoiMau nm = new NguoiMau("Antina", 24,
                false, "American tho",
                "90 - 90 - 90",
                "Adidas", meo);
        vdv.inThongTin();
        vdv.datChoDiDao();
        System.out.println("==================");
        nm.inThongTin();
        nm.datMeoDiShopping();
    }
}
