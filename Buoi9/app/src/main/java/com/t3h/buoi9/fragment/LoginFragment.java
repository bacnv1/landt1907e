package com.t3h.buoi9.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.t3h.buoi9.MainActivity;
import com.t3h.buoi9.R;

public class LoginFragment extends Fragment implements View.OnClickListener {
    private final String TAG = "LoginFragment";
    private EditText edtUserName;
    private EditText edtPassword;
    private Button btnLogin;
    private Button btnRegister;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView");
        return inflater.inflate(R.layout.fragment_login,
                container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onActivityCreated");
        edtUserName = getActivity().findViewById(R.id.edt_user_name);
        edtPassword = getActivity().findViewById(R.id.edt_password);
        btnLogin = getActivity().findViewById(R.id.btn_login);
        btnRegister = getActivity().findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                break;
            case R.id.btn_register:
                MainActivity act = (MainActivity) getActivity();
                act.showFragment(act.getFmRegister());
                break;
        }
    }

    public void setData(String userName, String password) {
        edtUserName.setText(userName);
        edtPassword.setText(password);
    }
}
