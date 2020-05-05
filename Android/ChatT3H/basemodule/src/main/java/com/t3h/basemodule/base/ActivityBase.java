package com.t3h.basemodule.base;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ActivityBase<BD extends ViewDataBinding> extends AppCompatActivity {
    protected BD binding;
    private RequestPermissionCallback callback;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(
                this,
                getLayoutId()
        );
        init();
    }

    protected abstract void init();

    protected abstract int getLayoutId();

    public void doRequestPermission(String[] permissions,
                                    RequestPermissionCallback callback) {
        if (checkPermission(permissions)) {
            callback.onGranted();
        } else {
            this.callback = callback;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(permissions, 0);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (checkPermission(permissions)) {
            callback.onGranted();
        } else {
            callback.onDenied();
        }
    }

    private boolean checkPermission(String[] permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (String p : permissions) {
                if (checkSelfPermission(p) ==
                        PackageManager.PERMISSION_DENIED) {
                    return false;
                }
            }
        }
        return true;
    }

    public interface RequestPermissionCallback {
        void onGranted();

        void onDenied();
    }
}
