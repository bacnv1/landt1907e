package com.t3h.buoi9.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.t3h.buoi9.MainActivity;
import com.t3h.buoi9.R;

public class RegisterFragment extends Fragment implements View.OnClickListener {
    private final String TAG = "RegisterFragment";
    private EditText edtUserName;
    private EditText edtPassword;
    private Button btnRegister;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView");
        return inflater.inflate(R.layout.fragment_register,
                container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onActivityCreated");
        edtUserName = getActivity().findViewById(R.id.edt_reg_user_name);
        edtPassword = getActivity().findViewById(R.id.edt_reg_password);
        btnRegister = getActivity().findViewById(R.id.btn_reg_register);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_reg_register:
                String userName = edtUserName.getText().toString();
                String password = edtPassword.getText().toString();
                if (userName.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getContext(), "Data empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                MainActivity act = (MainActivity) getActivity();
                act.showFragment(act.getFmLogin());
                act.getFmLogin().setData(userName, password);
                break;
        }
    }
}
