package br.com.digitalhouse.exercicios.exercicio1;

public class Exercicio1 {

    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa();
        try{
            System.out.println(pessoa.getRg()+0000);
        }catch (NullPointerException ex){
            System.out.println(ex.getMessage());
        }

    }

}
