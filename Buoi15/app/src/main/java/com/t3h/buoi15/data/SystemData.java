package com.t3h.buoi15.data;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.t3h.buoi15.models.Song;

import java.util.ArrayList;

public class SystemData {

    private ContentResolver resolver;

    public SystemData(Context context) {
        resolver = context.getContentResolver();
    }

    public ArrayList<Song> readData() {
        ArrayList<Song> arr = new ArrayList<>();
        Cursor cursor = resolver.query(
                MediaStore.Audio.Media.INTERNAL_CONTENT_URI,
                null,
                null,
                null,
                null
        );
        cursor.moveToFirst();
        int indexData = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.DATA);
        int indexTitle = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.TITLE);
        int indexSize = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.SIZE);
        int indexDuration = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.DURATION);
        int indexArtist = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.ARTIST);
        int indexAlbum = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.ALBUM);
        while (cursor.isAfterLast() == false) {
            String data = cursor.getString(indexData);
            String title = cursor.getString(indexTitle);
            int size = cursor.getInt(indexSize);
            int duration = cursor.getInt(indexDuration);
            String artist = cursor.getString(indexArtist);
            String album = cursor.getString(indexAlbum);
            Song song = new Song();
            song.setData(data);
            song.setTitle(title);
            song.setSize(size);
            song.setDuration(duration);
            song.setArtist(artist);
            song.setAlbum(album);
            arr.add(song);
            cursor.moveToNext();
        }
        return arr;
    }
}
