package com.t3h.buoi15.views;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.Observer;

import com.t3h.buoi15.MainActivity;
import com.t3h.buoi15.databinding.BottomControllerBinding;
import com.t3h.buoi15.models.SoundInfo;
import com.t3h.buoi15.service.MP3Service;

public class ControllerView extends FrameLayout implements ControllerListener, SeekBar.OnSeekBarChangeListener {

    private BottomControllerBinding binding;
    private MP3Service service;

    public ControllerView(@NonNull Context context) {
        super(context);
        init();
    }

    public ControllerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ControllerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ControllerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        binding = BottomControllerBinding.inflate(
                LayoutInflater.from(getContext()),
                this,
                true
        );
        Intent intent = new Intent(getContext(), MP3Service.class);
        getContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder b) {
            MP3Service.MP3Binder binder = (MP3Service.MP3Binder) b;
            service = binder.getService();
            bindView();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    private void bindView() {
        binding.setListener(this);
        MainActivity act = (MainActivity) getContext();
        service.getInfo().observe(act, new Observer<SoundInfo>() {
            @Override
            public void onChanged(SoundInfo soundInfo) {
                binding.setInfo(soundInfo);
                setVisibility(soundInfo.isStarting() ? VISIBLE : GONE);
            }
        });
        binding.sbTime.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onNext() {
        service.getController().change(1);
    }

    @Override
    public void onPrev() {
        service.getController().change(-1);
    }

    @Override
    public void onPause() {
        if (service.getController().isPlaying()) {
            service.getController().pause();
        } else {
            service.getController().start();
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser) {
            service.getController().seek(progress);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getContext().unbindService(connection);
    }
}
