package br.com.digitalhouse.tarefaImpressora;

public class Contrato implements Imprimivel {
    String nome;
    String tipo;

    public Contrato(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    @Override
    public void imprimir() {
        System.out.println("Sou um contrato muito legal: " + nome + "." +tipo);
    }

}
