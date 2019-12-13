package com.t3h.buoi13.register;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.t3h.buoi13.R;
import com.t3h.buoi13.databinding.ActivityRegisterBinding;
import com.t3h.buoi13.login.MainActivity;
import com.t3h.buoi13.views.ConfirmDialog;
import com.t3h.buoi13.views.DialogConfirmListener;

public class RegisterActivity extends AppCompatActivity implements RegisterListener, DialogConfirmListener {

    private ActivityRegisterBinding binding;
    private ConfirmDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        binding.setListener(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        dialog = new ConfirmDialog(this);
        dialog.setInfo("Exit", "Do you want to exit");
        dialog.setListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        dialog.show();
    }

    @Override
    public void onRegisterClicked() {
        String userName = binding.edtUserName.getText().toString();
        String password = binding.edtPassword.getText().toString();
        Intent data = new Intent();
        data.putExtra(MainActivity.EXTRA_USER_NAME, userName);
        data.putExtra(MainActivity.EXTRA_PASSWORD, password);
        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public void onOkClicked() {
        dialog.dismiss();
        finish();
    }

    @Override
    public void onCancelClicked() {
        dialog.dismiss();
    }
}
