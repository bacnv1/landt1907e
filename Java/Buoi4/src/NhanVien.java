public class NhanVien extends ConNguoi{
    String chucVu;
    String phongBan;
    int luong;

    public NhanVien(String ten, int tuoi, boolean gioiTinh, String diaChi, String sdt,
                    String chucVu, String phongBan, int luong) {
        super(ten, tuoi, gioiTinh, diaChi, sdt);
        this.chucVu = chucVu;
        this.phongBan = phongBan;
        this.luong = luong;
    }

    void diHoc() {
        System.out.println("Di bo di hoc");
    }

    void diHoc(int tien){
        System.out.println("Di hoc bang taxi het: " + tien);
    }

    @Override
    void inThongTin() {
        super.inThongTin();
        System.out.println("Chuc vu: "+ chucVu);
        System.out.println("Phong ban: " + phongBan);
        System.out.println("Luong: " + luong);
    }
}
