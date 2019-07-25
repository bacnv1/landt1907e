public class SoNguyen {
    int so;

    void nhap(int giaTriSo) {
        so = giaTriSo;
    }

    /**
     * kiểm tra một số có phải là số nguyên tố hay không
     * @return giá trị true nếu là số nguyên tố
     *                  false nếu không là số nguyên tố
     * */
    boolean kiemTra() {
        for (int i = 2; i < so; i++) {
            if (so % i == 0) {
                return false;
            }
        }
        return true;
    }

    void inKetQua(){
        boolean check = kiemTra();
        if (check == true) {
            System.out.println(so +" la so nguyen to");
        }else {
            System.out.println(so +" khong la so nguyen to");
        }
    }
}
