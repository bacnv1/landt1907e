package com.t3h.buoi11.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

public class PermissionUtils {
    /**
     * check user permissions is granted
     *
     * @param context     current activity or fragment
     * @param permissions list permissions need check
     * @return true if permissions is granted else denied
     */
    public static boolean checkPermissions(Context context
            , String[] permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (String p : permissions) {
                int result = ContextCompat.checkSelfPermission(context, p);
                if (result == PackageManager.PERMISSION_DENIED) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * request accept permission
     * @param activity current activity context
     * @param permission list permission need request to accept
     * @param requestCode
     * */
    public static void requestPermission(
            FragmentActivity activity,
            String[] permission,
            int requestCode
    ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            activity.requestPermissions(permission, requestCode);
        }
    }
}
