package br.digitalhouse.exercicioConta;

public class Conta {
    private int mumeroConta;
    private double saldo;
    private Cliente titular;

    public int getMumeroConta() {
        return mumeroConta;
    }

    public void setMumeroConta(int mumeroConta) {
        this.mumeroConta = mumeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public void deposito(double quantia) {
        System.out.println("Realizando deposito...  quantia: R$" + quantia);
        this.saldo += quantia;
        System.out.println("Deposito realizado " + this.titular.getNome() + ", novo saldo R$" + this.saldo);
    }

    public void saque(double quantia) {
        System.out.println("Realizando saque... quantia: R$" + quantia);

        if (this.saldo < quantia) {
            System.out.println("Saldo insuficiente, vc ta sem grana " + this.titular.getNome() + " :(");
            return;
        }

        this.saldo -= quantia;
        System.out.println("Saque realizado" + this.titular.getNome() + ", novo saldo R$" + this.saldo);
    }
}
