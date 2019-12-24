package com.t3h.buoi15;

import android.view.LayoutInflater;

import androidx.annotation.NonNull;

import com.t3h.basemodule.base.AdapterBase;
import com.t3h.basemodule.models.BaseModels;

public class AppAdapter<T extends BaseModels> extends AdapterBase<T> {

    public AppAdapter(LayoutInflater inflater, int resLayout) {
        super(inflater, resLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBase.HolderBase holder, int position) {
        T t = getData().get(position);
        holder.binding.setVariable(BR.item, t);
        if (listener != null) {
            holder.binding.setVariable(BR.listener, listener);
        }
        holder.binding.executePendingBindings();
    }
}
