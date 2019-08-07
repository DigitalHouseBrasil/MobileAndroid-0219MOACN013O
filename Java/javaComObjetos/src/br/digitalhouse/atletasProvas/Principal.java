package br.digitalhouse.atletasProvas;

public class Principal {

    public static void main(String[] args) {

        Atleta atleta1 = new Atleta();
        atleta1.setNome("Pedro");
        atleta1.setEnergia(10);
        atleta1.setNivel(10);

        Atleta atleta2 = new Atleta();
        atleta2.setNome("João");
        atleta2.setEnergia(15);
        atleta2.setNivel(25);

        Prova prova1 = new Prova();
        prova1.setDificudade(10);
        prova1.setEnergiaNecessaria(10);

        Prova prova2 = new Prova();
        prova1.setDificudade(12);
        prova1.setEnergiaNecessaria(11);

        Prova prova3 = new Prova();
        prova1.setDificudade(27);
        prova1.setEnergiaNecessaria(23);

        prova1.podeRealizar(atleta1);
        prova1.podeRealizar(atleta2);

        prova2.podeRealizar(atleta1);
        prova2.podeRealizar(atleta2);

        prova3.podeRealizar(atleta1);
        prova3.podeRealizar(atleta2);

    }
}
