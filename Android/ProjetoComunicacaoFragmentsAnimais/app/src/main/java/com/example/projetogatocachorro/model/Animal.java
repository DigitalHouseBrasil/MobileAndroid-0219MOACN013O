package com.example.projetogatocachorro.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Animal implements Parcelable {
    private int imagem;
    private String nome;

    public Animal(int imagem, String nome) {
        this.imagem = imagem;
        this.nome = nome;
    }

    protected Animal(Parcel in) {
        imagem = in.readInt();
        nome = in.readString();
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imagem);
        dest.writeString(nome);
    }
}
