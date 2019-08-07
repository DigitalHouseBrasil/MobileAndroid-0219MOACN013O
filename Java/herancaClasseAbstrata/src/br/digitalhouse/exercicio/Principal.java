package br.digitalhouse.exercicio;

public class Principal {

    public static void main(String[] args) {

        Cliente novoCliente = new Cliente();

        novoCliente.setNome("Jessica");
        novoCliente.setCpf("000000000000");

        ContaCorrente novaContaCorrente = new ContaCorrente();

        novaContaCorrente.setCliente(novoCliente);
        novaContaCorrente.saque(14);
        novaContaCorrente.deposito(234);





    }

}
