package com.t3h.buoi15.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.t3h.buoi15.controller.MediaController;
import com.t3h.buoi15.models.Song;

import java.util.ArrayList;

public class MP3Service extends Service {

    private MediaController controller;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(getClass().getSimpleName(), "onCreate");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(getClass().getSimpleName(), "onBind");
        return new MP3Binder(this);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(getClass().getSimpleName(), "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(getClass().getSimpleName(), "onDestroy");
    }

    public void setSongData(ArrayList<Song> arr) {
        if (controller != null) {
            controller.release();
        }
        controller = new MediaController(this, arr);
    }

    public MediaController getController() {
        return controller;
    }

    public class MP3Binder extends Binder {
        private MP3Service service;

        public MP3Binder(MP3Service service) {
            this.service = service;
        }

        public MP3Service getService() {
            return service;
        }
    }
}
