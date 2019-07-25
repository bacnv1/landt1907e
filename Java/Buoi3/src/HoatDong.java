public class HoatDong {
    int thu;

    void nhap(int gtThu) {
        thu = gtThu;
    }

    void getHoatDong() {
        if (thu == 2) {
            System.out.println("Da bong");
        } else if (thu == 3) {
            System.out.println("Di boi");
        } else if (thu == 4) {
            System.out.println("Choi game");
        } else if (thu == 5) {
            System.out.println("Ngu");
        } else if (thu == 6) {
            System.out.println("Di hoc");
        } else if (thu == 7) {
            System.out.println("O nha");
        } else if (thu == 8) {
            System.out.println("Ve que");
        } else {
            System.out.println("Khong phai la thu");
        }
    }

    void getHoatDongBySwtichCase() {
        switch (thu) {
            case 2:
                System.out.println("Da bong");
                break;
            case 3:
                System.out.println("Di boi");
                break;
            case 4:
                System.out.println("Choi game");
                break;
            case 5:
                System.out.println("Ngu");
                break;
            case 6:
                System.out.println("Di hoc");
                break;
            case 7:
                System.out.println("O nha");
                break;
            case 8:
                System.out.println("Ve que");
                break;
            default:
                System.out.println("Khong phai la thu");
                break;
        }
    }
}
