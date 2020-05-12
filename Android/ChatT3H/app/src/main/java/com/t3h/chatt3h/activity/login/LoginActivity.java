package com.t3h.chatt3h.activity.login;

import android.content.Intent;
import android.widget.Toast;

import com.t3h.basemodule.base.ActivityBase;
import com.t3h.chatt3h.R;
import com.t3h.chatt3h.activity.main.MainActivity;
import com.t3h.chatt3h.activity.register.RegisterActivity;
import com.t3h.chatt3h.api.ApiBuilder;
import com.t3h.chatt3h.databinding.ActivityLoginBinding;
import com.t3h.chatt3h.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends ActivityBase<ActivityLoginBinding> implements LoginListener {
    @Override
    protected void init() {
        binding.setListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void onLogin() {
        String userName = binding.edtUserName.getText().toString();
        String password = binding.edtPassword.getText().toString();
        ApiBuilder.getInstance().login(userName, password)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.code() == 200) {
                            Intent intent = MainActivity.getInstance(LoginActivity.this, response.body());
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this,
                                    "Login fail", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(LoginActivity.this,
                                "Login Fail", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onRegister() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
