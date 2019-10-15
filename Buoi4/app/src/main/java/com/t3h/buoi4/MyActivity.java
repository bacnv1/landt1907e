package com.t3h.buoi4;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MyActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = "MyActivity";
    private EditText edtNumberA;
    private EditText edtNumberB;
    private Button btnSum;
    private Button btnMinus;
    private TextView tvResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Log.v(TAG, "onCreate");

        initViews();
    }

    private void initViews() {
        edtNumberA = findViewById(R.id.edt_num_a);
        edtNumberB = findViewById(R.id.edt_num_b);
        tvResult = findViewById(R.id.tv_result);
        btnSum = findViewById(R.id.btn_sum);
        btnMinus = findViewById(R.id.btn_minus);

        btnSum.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    @Override
    public void onClick(View view) {
        String a = edtNumberA.getText().toString();
        String b = edtNumberB.getText().toString();
        if (a.isEmpty() || b.isEmpty()) {
            Toast.makeText(this,
                    "Data invalid", Toast.LENGTH_SHORT).show();
            return;
        }
        float numberA = Float.parseFloat(a);
        float numberB = Float.parseFloat(b);

        float result = 0f;
        switch (view.getId()) {
            case R.id.btn_sum:
                result = numberA + numberB;
                break;
            case R.id.btn_minus:
                result = numberA - numberB;
                break;
        }
        tvResult.setText(result + "");
    }
}
