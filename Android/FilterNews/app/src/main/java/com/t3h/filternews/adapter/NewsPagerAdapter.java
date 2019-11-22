package com.t3h.filternews.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.t3h.filternews.base.BaseFragment;

public class NewsPagerAdapter extends FragmentPagerAdapter {

    private BaseFragment[] fms;

    public NewsPagerAdapter(FragmentManager fm, BaseFragment ... fms) {
        super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.fms = fms;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fms[position];
    }

    @Override
    public int getCount() {
        return fms.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fms[position].getTitle();
    }
}
