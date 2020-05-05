package com.t3h.basemodule.base;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class BaseViewModel extends ViewModel {

    protected MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    protected MutableLiveData<Throwable> error = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();

    protected <T> void doAction(
            final AsyncAction<T> action,
            MutableLiveData<T> data
    ) {
        Observable<T> o = Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<T> emitter) throws Throwable {
                T t = action.doAction();
                emitter.onNext(t);
            }
        });
        subscribe(o, data);
    }

    protected <T> void subscribe(Observable<T> o, final MutableLiveData<T> data) {
        Disposable d = o.subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Throwable {
                        error.postValue(null);
                        isLoading.postValue(true);
                    }
                })
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Throwable {
                        isLoading.postValue(false);
                    }
                })
                .subscribe(new Consumer<T>() {
                    @Override
                    public void accept(T t) throws Throwable {
                        isLoading.postValue(false);
                        data.postValue(t);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        error.postValue(throwable);
                        isLoading.postValue(false);
                    }
                });
        disposable.add(d);

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }

    public interface AsyncAction<T> {
        T doAction() throws Exception;
    }
}
