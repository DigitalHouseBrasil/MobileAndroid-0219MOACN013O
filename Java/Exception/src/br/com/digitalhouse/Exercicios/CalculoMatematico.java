package br.com.digitalhouse.Exercicios;

public class CalculoMatematico {

    public int divisao(int divisor, int numero2) throws ArithmeticException {
        int divisao = 0;

        if (divisor == 0){
            throw new ArithmeticException("Estou lançando um ArithmeticException");
        }else{
            divisao = divisor/numero2;
        }
        return divisao;
    }

}
