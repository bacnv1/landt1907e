package com.t3h.buoi5;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtUserName;
    private EditText edtPassword;
    private Button btnOk;
    private Button btnRegister;

    private final int REQUEST_REGISTER = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    private void initViews() {
        edtUserName = findViewById(R.id.edt_user_name);
        edtPassword = findViewById(R.id.edt_password);
        btnOk = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);

        btnOk.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                String userName = edtUserName.getText().toString();
                String password = edtPassword.getText().toString();
                if (userName.isEmpty() || password.isEmpty()) {
                    Toast.makeText(this, "Data empty",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent i = new Intent(this, MainActivity.class);
                i.putExtra(RegisterActivity.EXTRA_USER_NAME, userName);
                i.putExtra(RegisterActivity.EXTRA_PASSWORD, password);
                startActivity(i);
                finish();
                break;
            case R.id.btn_register:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivityForResult(intent, REQUEST_REGISTER);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_REGISTER) {
            if (resultCode == RESULT_OK) {
                String userName = data.getStringExtra(RegisterActivity.EXTRA_USER_NAME);
                String password = data.getStringExtra(RegisterActivity.EXTRA_PASSWORD);
                edtPassword.setText(password);
                edtUserName.setText(userName);
            }else {
                Toast.makeText(this,
                        "Register cancelled", Toast.LENGTH_LONG).show();
            }
        }
    }
}
