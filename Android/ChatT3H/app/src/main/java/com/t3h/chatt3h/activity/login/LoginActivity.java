package com.t3h.chatt3h.activity.login;

import android.content.Intent;

import com.t3h.basemodule.base.ActivityBase;
import com.t3h.chatt3h.R;
import com.t3h.chatt3h.activity.register.RegisterActivity;
import com.t3h.chatt3h.databinding.ActivityLoginBinding;

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

    }

    @Override
    public void onRegister() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
