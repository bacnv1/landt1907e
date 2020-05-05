package com.t3h.chatt3h.activity.register;

import android.animation.TimeAnimator;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.t3h.basemodule.base.ActivityBase;
import com.t3h.chatt3h.R;
import com.t3h.chatt3h.databinding.ActivityRegisterBinding;
import com.t3h.chatt3h.model.Event;

public class RegisterActivity extends ActivityBase<ActivityRegisterBinding> implements RegisterListener, Observer<Event> {
    private RegisterViewModel viewModel;
    @Override
    protected void init() {
        binding.setListener(this);
        viewModel = ViewModelProviders.of(this).get(RegisterViewModel.class);
        viewModel.getEvent().observe(this, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void onRegister() {
        String email = binding.edtUserName.getText().toString();
        String password = binding.edtPassword.getText().toString();
        String name = binding.edtName.getText().toString();
        viewModel.register(
                email,
                password,
                name
        );
    }

    @Override
    public void onChanged(Event event) {
        if (event.isLoading()) {
            // show progress dialog
            return;
        }
        // dismiss progress dialog
        if (event.isSuccess()) {
            finish();
            return;
        }
        if (event.isFail()) {
            Toast.makeText(
                    this,
                    "Register fail",
                    Toast.LENGTH_LONG
            ).show();
        }
    }
}
