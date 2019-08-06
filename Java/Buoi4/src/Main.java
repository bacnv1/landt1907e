public class Main {
    public static void main(String[] args) {
        SinhVien sv = new SinhVien(
                "Nguyen Van A", 13, true, "Ha Noi",
                "012341231", "019111", 9.4f
        );
        sv.inThongTin();
        System.out.println("===============");
        NhanVien nv = new NhanVien(
                "Nguyen Thi B", 34, false, "Ha Noi",
                "021921211", "Senior", "HR",
                15000000
        );
        nv.inThongTin();
    }
}
