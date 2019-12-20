package com.t3h.buoi15.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.t3h.basemodule.base.AdapterBase;
import com.t3h.basemodule.base.FragmentBase;
import com.t3h.buoi15.AppAdapter;
import com.t3h.buoi15.R;
import com.t3h.buoi15.data.SystemData;
import com.t3h.buoi15.databinding.FragmentSongBinding;
import com.t3h.buoi15.models.Song;

public class SongFragment extends FragmentBase<FragmentSongBinding> {

    private AdapterBase<Song> adapter;
    private SystemData data;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_song;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new AppAdapter<>(getLayoutInflater(),
                R.layout.item_song);
        data = new SystemData(getContext());
        adapter.setData(data.readData());
        binding.lvSong.setAdapter(adapter);
    }
}
