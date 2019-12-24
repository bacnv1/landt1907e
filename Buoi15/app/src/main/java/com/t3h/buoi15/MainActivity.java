package com.t3h.buoi15;

import android.Manifest;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.t3h.basemodule.base.ActivityBase;
import com.t3h.basemodule.base.FragmentBase;
import com.t3h.buoi15.databinding.ActivityMainBinding;
import com.t3h.buoi15.fragments.album.AlbumFragment;
import com.t3h.buoi15.fragments.artist.ArtistFragment;
import com.t3h.buoi15.fragments.song.SongFragment;

public class MainActivity extends ActivityBase<ActivityMainBinding> implements BottomNavigationView.OnNavigationItemSelectedListener {

    private SongFragment fmSong = new SongFragment();
    private AlbumFragment fmAlbum = new AlbumFragment();
    private ArtistFragment fmArtist = new ArtistFragment();


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        doRequestPermission(
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                new RequestPermissionCallback() {
                    @Override
                    public void onGranted() {
                        initFragment();
                        binding.nav.setOnNavigationItemSelectedListener(
                                MainActivity.this
                        );
                    }

                    @Override
                    public void onDenied() {
                        finish();
                    }
                }
        );
    }

    private void initFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, fmSong);
        transaction.add(R.id.container, fmArtist);
        transaction.add(R.id.container, fmAlbum);
        transaction.commit();
        showFragment(fmSong);
    }

    private void showFragment(FragmentBase fmShow) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        transaction.hide(fmSong);
        transaction.hide(fmArtist);
        transaction.hide(fmAlbum);
        transaction.show(fmShow);
        transaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_songs:
                showFragment(fmSong);
                break;
            case R.id.nav_albums:
                showFragment(fmAlbum);
                break;
            case R.id.nav_artists:
                showFragment(fmArtist);
                break;
        }
        return true;
    }
}
