public class SinhVien extends ConNguoi {

    String maSv;
    float diem;

    public SinhVien(String ten, int tuoi, boolean gioiTinh, String diaChi, String sdt, String maSv, float diem) {
        super(ten, tuoi, gioiTinh, diaChi, sdt);
        this.maSv = maSv;
        this.diem = diem;
    }

    @Override
    void inThongTin() {
        super.inThongTin();
        System.out.println("Ma Sv: "+ maSv);
        System.out.println("Diem: "+ diem);
    }
}
