package br.com.digitalhouse.Exercicios;

public class Principal {

    public static void main(String[] args) {

        CalculoMatematico calculo = new CalculoMatematico();
        try{
            calculo.divisao(0,2);
        }catch (ArithmeticException ex){
            System.out.println(ex.getMessage());
        }


    }
}
