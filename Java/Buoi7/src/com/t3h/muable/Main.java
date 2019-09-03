package com.t3h.muable;

public class Main {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("Hello");
        builder.append(" world");
        builder.insert(4, "HAHAHA");
        builder.delete(10, 13);
        builder.reverse();

        System.out.println(builder);
    }
}
