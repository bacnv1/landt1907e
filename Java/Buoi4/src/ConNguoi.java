public class ConNguoi {
    String ten;
    int tuoi;
    boolean gioiTinh;
    String diaChi;
    String sdt;

    public ConNguoi(String ten, int tuoi, boolean gioiTinh,
                    String diaChi, String sdt) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    void inThongTin() {
        System.out.println("Ten: " + ten);
        System.out.println("Tuoi: " + tuoi);
        System.out.println("Gioi Tinh: " + (gioiTinh == true ? "Nam" : "Nu"));
        System.out.println("Dia Chi: " + diaChi);
        System.out.println("SDT: " + sdt);
    }
}
