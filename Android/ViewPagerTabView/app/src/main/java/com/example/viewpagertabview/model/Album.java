package com.example.viewpagertabview.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.fragment.app.Fragment;

public class Album {
    private int imagem;
    private String nomeAlbum;
    private Fragment fragment;

    public Album(String nomeAlbum, Fragment fragment) {
        this.nomeAlbum = nomeAlbum;
        this.fragment = fragment;
    }

    public int getImagem() {

        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getNomeAlbum() {
        return nomeAlbum;
    }

    public void setNomeAlbum(String nomeAlbum) {
        this.nomeAlbum = nomeAlbum;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}
