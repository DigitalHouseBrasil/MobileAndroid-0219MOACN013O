package br.digitalhouse.exercicio;

public class ContaCorrente extends Conta{
    private double limite;

    public void deposito(Cheque cheque) {
        System.out.println("Realizando deposito de cheque...  quantia: R$" + cheque.getValor());
        this.setSaldo(getSaldo() + cheque.getValor());
        System.out.println("Deposito realizado " + this.getCliente().getNome() + ", novo saldo R$" + this.getSaldo());
    }

    @Override
    public void saque(double quantia) {
        System.out.println("Realizando saque... quantia: R$" + quantia);

        if (this.getSaldo() < quantia) {
            System.out.println("Saldo insuficiente, sacando do limite, cuidado");

            if (limite > quantia) {
                this.setSaldo(getSaldo() - (limite - quantia));
                this.limite -= quantia;
            } else {
                System.out.println("Saldo insuficiente, vc ta sem grana " + this.getCliente().getNome() + " :(");
            }

            return;
        }

        this.setSaldo(this.getSaldo() - quantia);
        System.out.println("Saque realizado" + this.getCliente().getNome() + ", novo saldo R$" + this.getSaldo());
    }
}
