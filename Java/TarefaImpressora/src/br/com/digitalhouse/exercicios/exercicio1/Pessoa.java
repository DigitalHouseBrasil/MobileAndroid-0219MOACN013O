package br.com.digitalhouse.exercicios.exercicio1;

import java.util.Objects;

public class Pessoa {
    private String nome;
    private Integer rg;

    public Pessoa(String nome, Integer rg) {
        this.nome = nome;
        this.rg = rg;
    }

    public Pessoa(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }

        if (!(obj instanceof Pessoa)){
            return false;
        }

        return this.getRg() == ((Pessoa) obj).getRg();
    }



//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Pessoa)) return false;
//        Pessoa pessoa = (Pessoa) o;
//        return Objects.equals(getNome(), pessoa.getNome()) &&
//                Objects.equals(getRg(), pessoa.getRg());
//    }

}
