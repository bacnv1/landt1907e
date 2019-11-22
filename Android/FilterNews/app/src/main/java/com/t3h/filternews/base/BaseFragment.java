package com.t3h.filternews.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutResource(),
                container, false);
    }

    protected abstract int getLayoutResource();

    public abstract String getTitle();

    protected <T extends View> T findViewById(@IdRes int res) {
        return getActivity().findViewById(res);
    }
}
