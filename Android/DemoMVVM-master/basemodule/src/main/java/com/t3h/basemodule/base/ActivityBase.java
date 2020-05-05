package com.t3h.basemodule.base;

import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.Snackbar;

public abstract class ActivityBase<BD extends ViewDataBinding, VM extends BaseViewModel> extends AppCompatActivity {

    protected BD binding;
    private RequestPermissionCallback callback;
    protected VM viewModel;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(
                this,
                getLayoutId()
        );
        viewModel = new ViewModelProvider(this).get(getViewModelClass());

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");

        viewModel.isLoading.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean == true) {
                    progressDialog.show();
                } else {
                    progressDialog.dismiss();
                }
            }
        });

        viewModel.error.observe(this, new Observer<Throwable>() {
            @Override
            public void onChanged(Throwable throwable) {
                if (throwable != null) {
                    Snackbar.make(binding.getRoot(),
                            throwable.toString(),
                            Snackbar.LENGTH_LONG).show();
                }
            }
        });

        init();
    }

    protected abstract Class<VM> getViewModelClass();

    protected abstract int getLayoutId();

    protected abstract void init();

    public void doRequestPermission(String[] permissions, RequestPermissionCallback callback) {
        if (checkPermission(permissions)) {
            callback.onGranted();
        } else {
            this.callback = callback;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(permissions, 0);
            }
        }
    }

    public boolean checkPermission(String[] permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (String p : permissions) {
                if (checkSelfPermission(p) == PackageManager.PERMISSION_DENIED) {
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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (checkPermission(permissions)) {
            callback.onGranted();
        } else {
            callback.onDenied();
        }
    }
}
