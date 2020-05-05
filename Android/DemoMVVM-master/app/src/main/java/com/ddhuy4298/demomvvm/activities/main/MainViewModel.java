package com.ddhuy4298.demomvvm.activities.main;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.t3h.basemodule.base.BaseViewModel;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class MainViewModel extends BaseViewModel {

    private MutableLiveData<Bitmap> value = new MutableLiveData<>();

    public MutableLiveData<Bitmap> getValue() {
        return value;
    }

    public void startCounter(String link) {
        AsyncAction<Bitmap> b = new AsyncAction<Bitmap>() {
            @Override
            public Bitmap doAction() throws Exception{
                URL url = new URL(link);
                URLConnection connection = url.openConnection();
                return BitmapFactory.decodeStream(connection.getInputStream());
            }
        };
        doAction(b, value);
    }
}
