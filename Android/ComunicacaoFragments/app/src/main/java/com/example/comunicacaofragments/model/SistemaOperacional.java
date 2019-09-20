package com.example.comunicacaofragments.model;

import android.os.Parcel;
import android.os.Parcelable;

//Implementação da interface Parcelable para enviarmos um objeto através do bundle
public class SistemaOperacional implements Parcelable {
    private int imagem;
    private String nome;

    public SistemaOperacional() {
    }

    public SistemaOperacional(int imagem, String nomeAndroid) {
        this.imagem = imagem;
        this.nome = nomeAndroid;
    }

    //Implementações geradas através da implementação da interface Parcelable
    protected SistemaOperacional(Parcel in) {
        imagem = in.readInt();
        nome = in.readString();
    }

    //Implementações geradas através da implementação da interface Parcelable
    @Override
    public int describeContents() {
        return 0;
    }

    //Implementações geradas através da implementação da interface Parcelable
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imagem);
        dest.writeString(nome);
    }

    //Implementações geradas através da implementação da interface Parcelable
    public static final Creator<SistemaOperacional> CREATOR = new Creator<SistemaOperacional>() {
        @Override
        public SistemaOperacional createFromParcel(Parcel in) {
            return new SistemaOperacional(in);
        }

        @Override
        public SistemaOperacional[] newArray(int size) {
            return new SistemaOperacional[size];
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

}
