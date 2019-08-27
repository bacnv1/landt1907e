package com.t3h.immutable;

public class Main {
    public static void main(String[] args) {

        String str = "Hello world";
        int len = str.length();
        System.out.println(len);
        char c = str.charAt(2);
        System.out.println(c);
        int valueC = (int) c;
        System.out.println(valueC);
        int a = 65;
        char valueA = (char) a;
        System.out.println(valueA);
        int index = str.indexOf("l", 4);
        System.out.println(index);

        int indexL = str.indexOf("l");
        while (indexL != -1) {
            System.out.print(indexL + "\t");
            indexL = str.indexOf("l", indexL + 1);
        }
        str = str.replace("l", "L");
        System.out.println(str);
        String str1 = str.substring(6, 9);
        System.out.println(str1);
        str = str.toUpperCase();
        System.out.println(str);
        str = str.toLowerCase();
        System.out.println(str);


        str = "theo cách nói chung nhất, là bất kỳ tác phẩm nào bằng văn bản. Hiểu theo nghĩa hẹp hơn, thì văn học là dạng văn bản được coi là một hình thức nghệ thuật, hoặc bất kỳ một bài viết nào được coi là có giá trị nghệ thuật hoặc trí tuệ, thường là do cách thức triển khai ngôn ngữ theo";
        index = str.indexOf(" ");
        while (index != -1) {
            String v = str.substring(index, index + 2);
            str = str.replace(v, v.toUpperCase());
            index = str.indexOf(" ", index + 1);
        }
        str = str.trim();
        System.out.println(str);

        str = "      hellop     world       ";
        str = str.trim();
        System.out.println(str);

        str = "bacnv_123456_abc@gmail.com";
        String[] arr = str.split("_");
        String userName = arr[0];
        String password = arr[1];
        String email = arr[2];

        System.out.println(userName);
        System.out.println(password);
        System.out.println(email);

        boolean contains = str.contains("abc");
        System.out.println(contains);

        String s1 = "hello1s";
        String s2 = "H";
        boolean equals = s1.equals(s2);
        System.out.println(equals);
        boolean equalsIgnoreCase = s1.equalsIgnoreCase(s2);
        System.out.println(equalsIgnoreCase);

        int compare = s1.compareToIgnoreCase(s2);
        System.out.println(compare);

        int ascii = s1.codePointAt(0);
        System.out.println(ascii);
    }
}
