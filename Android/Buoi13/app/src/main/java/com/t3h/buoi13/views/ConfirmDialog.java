package com.t3h.buoi13.views;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;

import com.t3h.buoi13.databinding.DialogConfirmBinding;

public class ConfirmDialog extends Dialog {

    private DialogConfirmBinding binding;

    public ConfirmDialog(Context context) {
        super(context, android.R.style.Theme_Material_Dialog_NoActionBar_MinWidth);
        binding = DialogConfirmBinding
                .inflate(LayoutInflater.from(context));
        setContentView(binding.getRoot());
    }

    public void setInfo(String title, String message) {
        binding.setTitle(title);
        binding.setMessage(message);
    }

    public void setListener(DialogConfirmListener listener) {
        binding.setListener(listener);
    }
}
