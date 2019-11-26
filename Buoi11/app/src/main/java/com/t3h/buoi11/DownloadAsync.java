package com.t3h.buoi11;

import android.os.AsyncTask;

public class DownloadAsync extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... strings) {
        FileManager manager = new FileManager();
        return manager.download(strings[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
