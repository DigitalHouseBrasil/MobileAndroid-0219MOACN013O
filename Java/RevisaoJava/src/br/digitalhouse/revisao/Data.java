package br.digitalhouse.revisao;

public class Data {

    private int dia;
    private int mes;
    private int ano;

    public Data(int novoDia, int novoMes, int novoAno){
        dia = novoDia;
        mes = novoMes;
        ano = novoAno;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public void setDia(int novoDia) {
        dia = novoDia;
    }

    public void setMes(int novoMes) {
        mes = novoMes;
    }

    public void setAno(int novoAno) {
        ano = novoAno;
    }

    @Override
    public String toString() {
        return "Data{" +
                "dia=" + dia +
                ", mes=" + mes +
                ", ano=" + ano +
                '}';
    }
}
