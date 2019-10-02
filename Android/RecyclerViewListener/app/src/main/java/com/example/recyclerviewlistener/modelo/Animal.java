package com.example.recyclerviewlistener.modelo;

import android.os.Parcel;
import android.os.Parcelable;

//Implementação da interface Parcelable para o envio de objetos entre telas
public class Animal implements Parcelable {
    private int imagem;
    private String nome;
    private String detalhe;

    public Animal(int imagem, String nome, String detalhe) {
        this.imagem = imagem;
        this.nome = nome;
        this.detalhe = detalhe;
    }

    protected Animal(Parcel in) {
        imagem = in.readInt();
        nome = in.readString();
        detalhe = in.readString();
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

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imagem);
        dest.writeString(nome);
        dest.writeString(detalhe);
    }
}
