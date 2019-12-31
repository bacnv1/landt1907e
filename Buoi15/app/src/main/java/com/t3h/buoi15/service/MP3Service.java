package com.t3h.buoi15.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.t3h.buoi15.R;
import com.t3h.buoi15.controller.MediaController;
import com.t3h.buoi15.controller.MediaListener;
import com.t3h.buoi15.data.SystemData;
import com.t3h.buoi15.models.Song;

import java.util.ArrayList;

public class MP3Service extends Service implements MediaListener {

    private MediaController controller;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    private void pushNotify() {
        Intent intent = new Intent(this, getClass());
        startService(intent);
        NotificationManager manager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        String channel = "MP3Service";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel c = new NotificationChannel(
                    channel, channel, NotificationManager.IMPORTANCE_DEFAULT
            );
            manager.createNotificationChannel(c);
        }

        RemoteViews views = new RemoteViews(
                getPackageName(),
                R.layout.notification
        );
        views.setTextViewText(R.id.tv_title, controller.getName());

        NotificationCompat.Builder builder = new NotificationCompat.Builder(
                this,
                channel
        );
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setCustomBigContentView(views);
        startForeground(121221, builder.build());
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MP3Binder(this);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void setSongData(ArrayList<Song> arr) {
        if (controller != null) {
            controller.release();
        }
        controller = new MediaController(this, arr, this);
    }

    public MediaController getController() {
        return controller;
    }

    @Override
    public void onStarted() {
        pushNotify();
    }

    @Override
    public void onPaused() {
        pushNotify();
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
