package com.t3h.buoi15.controller;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

import com.t3h.buoi15.models.Song;

import java.util.ArrayList;

public class MediaController implements MediaPlayer.OnCompletionListener {
    private MediaPlayer player;
    private Context context;
    private ArrayList<Song> arrSong;
    private int index;

    public MediaController(Context context, ArrayList<Song> arrSong) {
        this.context = context;
        this.arrSong = arrSong;
    }

    public void create(int index) {
        this.index = index;
        release();
        player = MediaPlayer.create(
                context,
                Uri.parse(arrSong.get(index).getData())
        );
        start();
        player.setOnCompletionListener(this);
    }

    public void start() {
        if (player != null) {
            player.start();
        }
    }

    public void stop() {
        if (player != null) {
            player.stop();
        }
    }

    public void pause() {
        if (player != null) {
            player.pause();
        }
    }

    public void release() {
        if (player != null) {
            player.release();
        }
    }

    public void seek(int position) {
        if (player != null) {
            player.seekTo(position);
        }
    }

    public void loop(boolean isLoop) {
        if (player != null) {
            player.setLooping(isLoop);
        }
    }

    public int getDuration() {
        if (player != null) {
            return player.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        return player == null ? 0 : player.getCurrentPosition();
    }

    public String getName() {
        if (arrSong.size() > index) {
            return arrSong.get(index).getTitle();
        }
        return "";
    }

    // value = 1 / -1
    public void change(int value) {
        index += value;
        if (index >= arrSong.size()) {
            index = 0;
        } else if (index < 0) {
            index = arrSong.size() - 1;
        }
        create(index);
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        change(1);
    }
}
