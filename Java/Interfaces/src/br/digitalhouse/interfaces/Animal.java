package br.digitalhouse.interfaces;

public abstract class Animal implements Brincavel {

    private String raca;
    private int idade;
    private String cor;

    public Animal(String novaRaca){
        raca = novaRaca;
    }

    public String getRaca() {
        return raca;
    }

    public int getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String novaCor) {
        cor = novaCor;
    }

    public void setIdade(int novaIdade) {
        idade = novaIdade;
    }

    public void setRaca(String novaRaca) {
        raca = novaRaca;
    }
}
