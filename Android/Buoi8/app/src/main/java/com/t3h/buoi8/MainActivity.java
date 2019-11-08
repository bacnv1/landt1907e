package com.t3h.buoi8;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Runnable, DownloadAsync.DownloadFileCallBack {

    private TextView tvTime;
    private Button btnStart;
    private Button btnEnd;
    private boolean isRunning = false;
    private final int WHAT_TIME = 1;

    private Button btnDownload;
    private EditText edtDownload;
    private ImageView imDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        tvTime = findViewById(R.id.tv_time);
        btnEnd = findViewById(R.id.btn_end);
        btnStart = findViewById(R.id.btn_start);
        btnStart.setOnClickListener(this);
        btnEnd.setOnClickListener(this);

        btnDownload = findViewById(R.id.btn_download);
        edtDownload = findViewById(R.id.edt_download);
        imDownload = findViewById(R.id.im_download);
        btnDownload.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                isRunning = true;
                btnStart.setEnabled(false);
                Thread t = new Thread(this);
                t.start();
                break;
            case R.id.btn_end:
                isRunning = false;
                btnStart.setEnabled(true);
                break;
            case R.id.btn_download:
                String link = edtDownload.getText().toString();
                DownloadAsync async = new DownloadAsync(this);
                async.execute(link);
                break;
        }
    }

    @Override
    public void run() {
        int i = 0;
        while (isRunning) {
            Log.e(getClass().getName(), "run");
            i++;
            Message msg = new Message();
            msg.what = WHAT_TIME;
            msg.arg1 = i;
            handler.sendMessage(msg);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case WHAT_TIME:
                    tvTime.setText(msg.arg1 + "");
                    break;
            }
        }
    };

    @Override
    public void onDownloadResult(Bitmap bitmap) {
        imDownload.setImageBitmap(bitmap);
    }
}
