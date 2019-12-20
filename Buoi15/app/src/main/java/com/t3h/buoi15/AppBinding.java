package com.t3h.buoi15;

import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class AppBinding {
    private static SimpleDateFormat format =
            new SimpleDateFormat("mm:ss");

    @BindingAdapter("app:duration")
    public static void setDuration(TextView tv, int duration) {
        tv.setText(format.format(duration));
    }

    public static String readableFileSize(long size) {
        if(size <= 0) return "0";
        final String[] units = new String[] { "B", "kB", "MB", "GB", "TB" };
        int digitGroups = (int) (Math.log10(size)/Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size/Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }

    @BindingAdapter("app:size")
    public static void setSize(TextView tv, int size) {
        tv.setText(readableFileSize(size));
    }
}
