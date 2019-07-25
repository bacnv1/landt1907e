public class LietKe{
    int gioiHan;
    SoNguyen sn = new SoNguyen();

    void nhap(int gtGioiHan){
        gioiHan = gtGioiHan;
    }

    void lietKe() {
        for (int i = 2; i <= gioiHan; i++) {
            sn.nhap(i);
            boolean check = sn.kiemTra();
            if (check == true) {
                System.out.print(i +" ");
            }
//            boolean check = true;
//            for (int j = 2; j < i; j++) {
//                if (i % j == 0) {
//                    check = false;
//                    break;
//                }
//            }
//            if (check == true){
//                System.out.print(i +" ");
//            }
        }
    }
}
