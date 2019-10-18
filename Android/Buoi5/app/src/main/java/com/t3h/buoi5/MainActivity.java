package com.t3h.buoi5;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvInfo;
    private EditText edtValue;
    private Button btnCall;
    private Button btnBrowser;
    private Button btnGalley;
    private ImageView imGallery;
    private final int REQUEST_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        tvInfo = findViewById(R.id.tv_info);
        edtValue = findViewById(R.id.edt_value);
        btnCall = findViewById(R.id.btn_call);
        btnBrowser = findViewById(R.id.btn_browser);
        btnGalley = findViewById(R.id.btn_gallery);
        imGallery = findViewById(R.id.im_gallery);

        btnGalley.setOnClickListener(this);
        btnBrowser.setOnClickListener(this);
        btnCall.setOnClickListener(this);

        Intent intent = getIntent();
        String userName = intent.getStringExtra(RegisterActivity.EXTRA_USER_NAME);
        String password = intent.getStringExtra(RegisterActivity.EXTRA_PASSWORD);
        tvInfo.setText(userName +" - " + password);
    }

    @Override
    public void onClick(View v) {
        String value = edtValue.getText().toString();
        switch (v.getId()) {
            case R.id.btn_call:
                Intent call = new Intent(Intent.ACTION_CALL);
                Uri uri = Uri.parse("tel:" + value);
                call.setData(uri);
                startActivity(call);
                break;
            case R.id.btn_browser:
                Intent browser = new Intent(Intent.ACTION_VIEW);
                browser.setData(Uri.parse(value));
                startActivity(browser);
                break;
            case R.id.btn_gallery:
                Intent gallery = new Intent(Intent.ACTION_GET_CONTENT);
                gallery.setType("image/*");
                startActivityForResult(
                        Intent.createChooser(gallery, "Pick image"),
                        REQUEST_IMAGE
                );
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE) {
            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();
                imGallery.setImageURI(uri);
            }
        }
    }
}
