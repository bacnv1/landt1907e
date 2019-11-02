package com.t3h.buoi7.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.buoi7.R;
import com.t3h.buoi7.models.Face;

import java.util.ArrayList;

public class FaceAdapter extends RecyclerView.Adapter<FaceAdapter.FaceHolder> {
    private ArrayList<Face> data;
    private LayoutInflater inflater;
    private FaceItemListener listener;

    public FaceAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public void setData(ArrayList<Face> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setListener(FaceItemListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public FaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.e(getClass().getName(), "onCreateViewHolder");
        View v = inflater.inflate(
                R.layout.item_face,
                parent,
                false
        );
        return new FaceHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FaceHolder holder, final int position) {
        Face item = data.get(position);
        holder.bindData(item);
        Log.e(getClass().getName(), "Load: " + position);
        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onFaceItemClick(position);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onFaceItemLongClick(position);
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class FaceHolder extends RecyclerView.ViewHolder {

        private ImageView imFace;
        private TextView tvFace;

        public FaceHolder(@NonNull View itemView) {
            super(itemView);
            imFace = itemView.findViewById(R.id.im_face);
            tvFace = itemView.findViewById(R.id.tv_face);
        }

        public void bindData(Face item) {
            imFace.setImageResource(item.getIcon());
            tvFace.setText(item.getName());
        }
    }

    public interface FaceItemListener {
        void onFaceItemClick(int position);
        void onFaceItemLongClick(int position);
    }
}
