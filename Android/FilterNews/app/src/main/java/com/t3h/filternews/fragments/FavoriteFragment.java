package com.t3h.filternews.fragments;

import com.t3h.filternews.R;
import com.t3h.filternews.base.BaseFragment;

public class FavoriteFragment extends BaseFragment {
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_favorite;
    }

    @Override
    public String getTitle() {
        return "Favorite";
    }
}
