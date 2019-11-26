package com.t3h.buoi11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;

import com.t3h.buoi11.utils.PermissionUtils;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FileManager manager;
    private File[] files;

    private final String[] PERMISSIONS = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (PermissionUtils.checkPermissions(this, PERMISSIONS)) {
            initViews();
        } else {
            PermissionUtils.requestPermission(this,
                    PERMISSIONS, 0);
        }
    }

    private void initViews() {
        manager = new FileManager();
        files = manager.getFiles(manager.getRootPath());

        String link = "https://www.24h.com.vn/bong-da/ronaldo-sang-cua-doat-qua-bong-vang-noi-dieu-bat-ngo-ve-dai-kinh-dich-messi-c48a1095309.html";
        new DownloadAsync().execute(link);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        boolean result = PermissionUtils.checkPermissions(
                this, permissions
        );
        if (result) {
            initViews();
        }else {
            finish();
        }
    }
}
