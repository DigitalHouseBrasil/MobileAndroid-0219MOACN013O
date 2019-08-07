package br.digitalhouse.exercicio;

public abstract class Conta {
    private Cliente cliente;
    private double saldo;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void deposito(double quantia) {
        System.out.println("Realizando deposito...  quantia: R$" + quantia);
        this.saldo = saldo + quantia;
        System.out.println("Deposito realizado " + this.cliente.getNome() + ", novo saldo R$" + this.saldo);
    }

    public void saque(double quantia) {
        System.out.println("Realizando saque... quantia: R$" + quantia);

        if (this.saldo < quantia) {
            System.out.println("Saldo insuficiente, vc ta sem grana " + this.cliente.getNome() + " :(");
            return;
        }

        this.saldo = saldo - quantia;
        System.out.println("Saque realizado" + this.cliente.getNome() + ", novo saldo R$" + this.saldo);
    }
}
