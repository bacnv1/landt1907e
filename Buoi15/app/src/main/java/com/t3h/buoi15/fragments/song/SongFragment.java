package com.t3h.buoi15.fragments.song;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.t3h.basemodule.base.AdapterBase;
import com.t3h.basemodule.base.FragmentBase;
import com.t3h.buoi15.AppAdapter;
import com.t3h.buoi15.MainActivity;
import com.t3h.buoi15.R;
import com.t3h.buoi15.controller.MediaController;
import com.t3h.buoi15.data.SystemData;
import com.t3h.buoi15.databinding.FragmentSongBinding;
import com.t3h.buoi15.models.Song;
import com.t3h.buoi15.service.MP3Service;

public class SongFragment extends FragmentBase<FragmentSongBinding> implements SongItemListener{

    private AdapterBase<Song> adapter;
    private SystemData data;
    private MP3Service service;

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
        adapter.setListener(this);
        binding.lvSong.setAdapter(adapter);

        MainActivity act = (MainActivity) getActivity();
        service = act.getService();
    }

    @Override
    public void onItemSongClicked(Song item) {
        int index = adapter.getData().indexOf(item);
        service.setSongData(adapter.getData());
        service.getController().create(index);
    }
}
