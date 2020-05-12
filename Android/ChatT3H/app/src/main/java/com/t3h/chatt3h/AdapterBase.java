package com.t3h.chatt3h;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.basemodule.base.AdapterBaseListener;
import com.t3h.basemodule.models.BaseModels;

import java.util.ArrayList;
import java.util.List;

public class AdapterBase<T extends BaseModels> extends RecyclerView.Adapter<AdapterBase.HolderBase>{
    private List<T> data;
    private LayoutInflater inflater;
    private int resLayout;
    protected AdapterBaseListener listener;

    public AdapterBase(LayoutInflater inflater,
                       @LayoutRes int resLayout) {
        this.inflater = inflater;
        this.resLayout = resLayout;
    }

    public void setListener(AdapterBaseListener listener) {
        this.listener = listener;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HolderBase onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(inflater,
                resLayout, parent, false);
        return new HolderBase(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBase.HolderBase holder, int position) {
        holder.binding.setVariable(BR.item, data.get(position));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class HolderBase extends RecyclerView.ViewHolder {
        public ViewDataBinding binding;
        public HolderBase(@NonNull ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
