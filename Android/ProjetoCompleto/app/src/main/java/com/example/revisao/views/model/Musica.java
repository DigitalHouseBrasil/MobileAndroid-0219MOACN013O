package com.example.revisao.views.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Musica implements Parcelable {
    private String nome;
    private String letraMusica;

    public Musica(String nome) {
        this.nome = nome;
    }

    public Musica(String nome, String letraMusica) {
        this.nome = nome;
        this.letraMusica = letraMusica;
    }

    protected Musica(Parcel in) {
        nome = in.readString();
        letraMusica = in.readString();
    }

    public static final Creator<Musica> CREATOR = new Creator<Musica>() {
        @Override
        public Musica createFromParcel(Parcel in) {
            return new Musica(in);
        }

        @Override
        public Musica[] newArray(int size) {
            return new Musica[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLetraMusica() {
        return letraMusica;
    }

    public void setLetraMusica(String letraMusica) {
        this.letraMusica = letraMusica;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(letraMusica);
    }
}

