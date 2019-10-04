package com.example.viewpagertabview.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.viewpagertabview.model.Album;

import java.util.List;

public class AlbumPageAdapter extends FragmentStatePagerAdapter {

    private List<Album> albumList;

    public AlbumPageAdapter(FragmentManager fm, List<Album> albumList){
        super(fm);
        this.albumList = albumList;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return albumList.get(position).getNomeAlbum();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return albumList.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return albumList.size();
    }
}
