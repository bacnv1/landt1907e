package com.t3h.exceptions;

public class FixMe {
    private StringBuilder builder = new StringBuilder();

    public FixMe() {
        builder.append("Hello");
        builder.append("World");
    }

    public void sumDigit() {
        int sum = 0;
        for (int i = 0; i < builder.length(); i++) {
            sum += builder.codePointAt(i);
        }
        System.out.println(sum);
    }
}
