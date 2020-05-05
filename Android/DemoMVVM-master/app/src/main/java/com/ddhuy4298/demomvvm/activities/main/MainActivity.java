package com.ddhuy4298.demomvvm.activities.main;

import android.graphics.Bitmap;

import androidx.lifecycle.Observer;

import com.ddhuy4298.demomvvm.R;
import com.ddhuy4298.demomvvm.databinding.ActivityMainBinding;
import com.t3h.basemodule.base.ActivityBase;

public class MainActivity extends ActivityBase<ActivityMainBinding, MainViewModel> implements MainListener {

    @Override
    protected Class<MainViewModel> getViewModelClass() {
        return MainViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        binding.setListener(this);
        binding.setLifecycleOwner(this);

        viewModel.getValue().observe(this, new Observer<Bitmap>() {
            @Override
            public void onChanged(Bitmap bitmap) {
                binding.imDownload.setImageBitmap(bitmap);
            }
        });
    }

    @Override
    public void onStartClicked() {
        viewModel.startCounter("https://wallpaperset.com/2w/full/6/d/2/249772.jpg");
    }
}
