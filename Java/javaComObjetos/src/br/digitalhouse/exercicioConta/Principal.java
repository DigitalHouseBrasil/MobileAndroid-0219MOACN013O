package br.digitalhouse.exercicioConta;

public class Principal {

    public static void main(String[] args) {

        Cliente clienteErika = new Cliente();
        clienteErika.setNome("Erika");
        clienteErika.setSobrenome("iOS");

        Conta contaErika = new Conta();
        contaErika.setSaldo(100);
        contaErika.setTitular(clienteErika);

        Cliente clienteJessica = new Cliente();
        clienteJessica.setNome("Jessica");
        clienteJessica.setSobrenome("Android");

        Conta contaJessica = new Conta();
        contaJessica.setSaldo(150);
        contaJessica.setTitular(clienteJessica);

        contaErika.deposito(1200);
        contaJessica.saque(200);
    }

}
