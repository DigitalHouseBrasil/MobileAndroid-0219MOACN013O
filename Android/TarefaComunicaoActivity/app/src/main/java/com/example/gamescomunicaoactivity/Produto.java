package com.example.gamescomunicaoactivity;

import android.os.Parcel;
import android.os.Parcelable;

public class Produto implements Parcelable {
    private String nome;
    private String valor;

    public Produto(String nome, String valor) {
        this.nome = nome;
        this.valor = valor;
    }

    protected Produto(Parcel in) {
        nome = in.readString();
        valor = in.readString();
    }

    public static final Creator<Produto> CREATOR = new Creator<Produto>() {
        @Override
        public Produto createFromParcel(Parcel in) {
            return new Produto(in);
        }

        @Override
        public Produto[] newArray(int size) {
            return new Produto[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(valor);
    }
}
