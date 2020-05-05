package com.t3h.basemodule.base;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.basemodule.model.BaseModels;

import java.util.ArrayList;

public abstract class AdapterBase<T extends BaseModels> extends RecyclerView.Adapter<AdapterBase.HolderBase> {

    private ArrayList<T> data;
    private LayoutInflater inflater;
    private int resLayout;
    protected AdapterBaseListener listener;

    public AdapterBase(LayoutInflater inflater, @LayoutRes int resLayout) {
        this.inflater = inflater;
        this.resLayout = resLayout;
    }

    public ArrayList<T> getData() {
        return data;
    }

    public void setData(ArrayList<T> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setListener(AdapterBaseListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public HolderBase onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ViewDataBinding binding = DataBindingUtil.inflate(inflater, resLayout, parent, false);

        return new HolderBase(binding);
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
