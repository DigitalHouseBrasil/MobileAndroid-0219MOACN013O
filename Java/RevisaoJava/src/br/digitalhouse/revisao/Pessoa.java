package br.digitalhouse.revisao;

public abstract class Pessoa {

    private String nome;
    private Data nascimento;

    public Pessoa(String novoNome, Data novoNascimento){
        nome = novoNome;
        nascimento = novoNascimento;
    }

    public abstract void imprimeDados();

    public String getNome() {
        return nome;
    }

    public Data getNascimento() {
        return nascimento;
    }

    public void setNome(String novoNome) {
        nome = novoNome;
    }

    public void setNascimento(Data novoNascimento) {
        nascimento = novoNascimento;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", nascimento=" + nascimento +
                '}';
    }
}
