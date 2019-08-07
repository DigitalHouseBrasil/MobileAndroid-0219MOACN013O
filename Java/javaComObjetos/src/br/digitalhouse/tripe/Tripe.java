package br.digitalhouse.tripe;

public class Tripe {

    private boolean dobrado;
    private int alturaMimima;
    private int alturaMaxima;
    private int alturaAtual;

    public boolean isDobrado() {
        return dobrado;
    }

    public void setDobrado(boolean dobrado) {
        this.dobrado = dobrado;
    }

    public int getAlturaMimima() {
        return alturaMimima;
    }

    public void setAlturaMimima(int alturaMimima) {
        this.alturaMimima = alturaMimima;
    }

    public int getAlturaMaxima() {
        return alturaMaxima;
    }

    public void setAlturaMaxima(int alturaMaxima) {
        this.alturaMaxima = alturaMaxima;
    }

    public int getAlturaAtual() {
        return alturaAtual;
    }

    public void setAlturaAtual(int alturaAtual) {
        this.alturaAtual = alturaAtual;
    }

    public void dobrar() {
        this.dobrado = true;
    }

    public void desdobrar() {
        this.dobrado = false;
    }

    public void guardar() {
        this.dobrado = true;
        this.alturaAtual = this.alturaMimima;
    }

    public boolean prontoParaGuardar() {
        return this.dobrado && this.alturaAtual == this.alturaMimima;
    }

    public void usar() {
        this.dobrado = false;
        this.alturaAtual = this.alturaMaxima;
    }

    public boolean prontoParaUsar() {
        return this.dobrado && this.alturaAtual > this.alturaMaxima / 2;
    }

}
