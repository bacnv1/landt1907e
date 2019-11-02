package com.t3h.buoi7;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.t3h.buoi7.adapter.FaceAdapter;
import com.t3h.buoi7.models.Face;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FaceAdapter.FaceItemListener {

    private RecyclerView lvFace;
    private ArrayList<Face> data;
    private FaceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initData();
    }

    private void initData() {
        data = new ArrayList<>();
        data.add(new Face(R.drawable.beauty, "Beautifully"));
        data.add(new Face(R.drawable.cry, "Cry"));
        data.add(new Face(R.drawable.doubt, "Doubt"));
        data.add(new Face(R.drawable.love, "Love"));
        data.add(new Face(R.drawable.what, "What"));
        data.add(new Face(R.drawable.beauty, "Beautifully"));
        data.add(new Face(R.drawable.cry, "Cry"));
        data.add(new Face(R.drawable.doubt, "Doubt"));
        data.add(new Face(R.drawable.love, "Love"));
        data.add(new Face(R.drawable.what, "What"));
        data.add(new Face(R.drawable.beauty, "Beautifully"));
        data.add(new Face(R.drawable.cry, "Cry"));
        data.add(new Face(R.drawable.doubt, "Doubt"));
        data.add(new Face(R.drawable.love, "Love"));
        data.add(new Face(R.drawable.what, "What"));
        data.add(new Face(R.drawable.beauty, "Beautifully"));
        data.add(new Face(R.drawable.cry, "Cry"));
        data.add(new Face(R.drawable.doubt, "Doubt"));
        data.add(new Face(R.drawable.love, "Love"));
        data.add(new Face(R.drawable.what, "What"));
        data.add(new Face(R.drawable.beauty, "Beautifully"));
        data.add(new Face(R.drawable.cry, "Cry"));
        data.add(new Face(R.drawable.doubt, "Doubt"));
        data.add(new Face(R.drawable.love, "Love"));
        data.add(new Face(R.drawable.what, "What"));
        data.add(new Face(R.drawable.beauty, "Beautifully"));
        data.add(new Face(R.drawable.cry, "Cry"));
        data.add(new Face(R.drawable.doubt, "Doubt"));
        data.add(new Face(R.drawable.love, "Love"));
        data.add(new Face(R.drawable.what, "What"));
        data.add(new Face(R.drawable.beauty, "Beautifully"));
        data.add(new Face(R.drawable.cry, "Cry"));
        data.add(new Face(R.drawable.doubt, "Doubt"));
        data.add(new Face(R.drawable.love, "Love"));
        data.add(new Face(R.drawable.what, "What"));
        data.add(new Face(R.drawable.beauty, "Beautifully"));
        data.add(new Face(R.drawable.cry, "Cry"));
        data.add(new Face(R.drawable.doubt, "Doubt"));
        data.add(new Face(R.drawable.love, "Love"));
        data.add(new Face(R.drawable.what, "What"));
        data.add(new Face(R.drawable.beauty, "Beautifully"));
        data.add(new Face(R.drawable.cry, "Cry"));
        data.add(new Face(R.drawable.doubt, "Doubt"));
        data.add(new Face(R.drawable.love, "Love"));
        data.add(new Face(R.drawable.what, "What"));
        data.add(new Face(R.drawable.beauty, "Beautifully"));
        data.add(new Face(R.drawable.cry, "Cry"));
        data.add(new Face(R.drawable.doubt, "Doubt"));
        data.add(new Face(R.drawable.love, "Love"));
        data.add(new Face(R.drawable.what, "What"));
        adapter.setData(data);
    }

    private void initViews() {
        lvFace = findViewById(R.id.lv_face);
        adapter = new FaceAdapter(getLayoutInflater());
        lvFace.setAdapter(adapter);
        adapter.setListener(this);
    }

    @Override
    public void onFaceItemClick(int position) {
        Toast.makeText(this,
                "Click: " + data.get(position).getName(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFaceItemLongClick(final int position) {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Delete")
                .setMessage("Do you want to delete: "
                        + data.get(position).getName())
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        data.remove(position);
                        adapter.notifyItemRemoved(position);
                        adapter.notifyItemRangeChanged(position, data.size());
                        dialog.dismiss();
                    }
                })
                .create();
//        dialog.setCanceledOnTouchOutside(false);
//        dialog.setCancelable(false);
        dialog.show();

    }
}
