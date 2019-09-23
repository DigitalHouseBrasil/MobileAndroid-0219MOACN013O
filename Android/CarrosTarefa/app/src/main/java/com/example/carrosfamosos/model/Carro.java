package com.example.carrosfamosos.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Carro implements Parcelable {
    private int image;
    private String nome;

    public Carro(int image, String nome) {
        this.image = image;
        this.nome = nome;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    protected Carro(Parcel in) {
        image = in.readInt();
        nome = in.readString();
    }

    public static final Creator<Carro> CREATOR = new Creator<Carro>() {
        @Override
        public Carro createFromParcel(Parcel in) {
            return new Carro(in);
        }

        @Override
        public Carro[] newArray(int size) {
            return new Carro[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(image);
        parcel.writeString(nome);
    }
}
