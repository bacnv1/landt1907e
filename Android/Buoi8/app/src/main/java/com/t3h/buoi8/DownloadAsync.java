package com.t3h.buoi8;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadAsync extends AsyncTask<String, Void, Bitmap> {

    private DownloadFileCallBack callBack;

    public DownloadAsync(DownloadFileCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        String link = strings[0];
        try {
            URL url = new URL(link);
            URLConnection connection = url.openConnection();
            InputStream stream = connection.getInputStream();
            return BitmapFactory.decodeStream(stream);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Bitmap s) {
        super.onPostExecute(s);
        callBack.onDownloadResult(s);
    }

    public interface DownloadFileCallBack {
        void onDownloadResult(Bitmap bitmap);
    }
}
