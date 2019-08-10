package br.digitalhouse.revisao;

public class Funcionario extends Pessoa implements Imposto {

    private float salario;
    private float porcentagem;


    public Funcionario(String novoNome, Data novoNascimento, float novoSalario) {
        super(novoNome, novoNascimento);
        salario = novoSalario;
    }


    @Override
    public float calculaImposto() {
        float calImposto = (float) (salario * 0.03);
        return calImposto;
    }


    @Override
    public void imprimeDados() {
        float salarioComImposto = salario - calculaImposto();
        System.out.println("O valor final do calculo é de: " + salarioComImposto);
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float novoSalario) {
        salario = novoSalario;
    }


}
