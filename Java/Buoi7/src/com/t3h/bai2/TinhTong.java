package com.t3h.bai2;
public class TinhTong {
    private String str;
    public TinhTong(String str) {
        this.str = str;
    }
    public void chuanHoa() {
        str = str.replace("++", "+0+");
        str = str.replace("--", "-0-");
        str = str.replace("+-", "-");
        str = str.replace("-+", "-");
        System.out.println(str);
    }
    public void tinhToan() {
        int tong = 0;
        String[] arr = str.split("\\+");
        for (int i = 0; i < arr.length; i++) {
            String[] arr1 = arr[i].split("-");
            for (int j = 0; j < arr1.length; j++) {
                if (j == 0) {
                    tong += Integer.parseInt(arr1[j]);
                }else {
                    tong -= Integer.parseInt(arr1[j]);
                }
            }
        }
        System.out.println("Tong la: "+ tong);
    }
}
