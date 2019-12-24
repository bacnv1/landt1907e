package com.t3h.buoi15.fragments.song;

import com.t3h.basemodule.base.AdapterBaseListener;
import com.t3h.buoi15.models.Song;

public interface SongItemListener extends AdapterBaseListener {
    void onItemSongClicked(Song item);
}
