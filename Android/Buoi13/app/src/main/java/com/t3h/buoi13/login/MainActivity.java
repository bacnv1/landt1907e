package com.t3h.buoi13.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.t3h.buoi13.R;
import com.t3h.buoi13.databinding.ActivityMainBinding;
import com.t3h.buoi13.register.RegisterActivity;
import com.t3h.buoi13.utils.ToastUtils;

public class MainActivity extends AppCompatActivity implements LoginListener {

    private static final int REQUEST_REGISTER = 1;
    public static final String EXTRA_USER_NAME = "extra.user.name";
    public static final String EXTRA_PASSWORD = "extra.password";
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(
                this, R.layout.activity_main
        );
        binding.setListener(this);
    }

    @Override
    public void onLoginClicked() {
        ToastUtils.show(this, "lOGIN CLIKC");
    }

    @Override
    public void onRegisterClicked() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivityForResult(intent, REQUEST_REGISTER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_REGISTER) {
            if (resultCode == RESULT_OK) {
                String userName = data.getStringExtra(EXTRA_USER_NAME);
                String password = data.getStringExtra(EXTRA_PASSWORD);
                binding.edtPassword.setText(password);
                binding.edtUserName.setText(userName);
            }
        }
    }
}
