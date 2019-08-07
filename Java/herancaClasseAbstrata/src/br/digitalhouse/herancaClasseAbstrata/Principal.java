package br.digitalhouse.herancaClasseAbstrata;

public class Principal {

    public static void main(String[] args) {

        Crianca bebe = new Crianca("Maria", "feminino");

        System.out.println(bebe.getNome() + "\n" + bebe.getSexo() );
        //System.out.println(bebe.getSexo());

        bebe.estudar(true);

        bebe.respirar("Jessica");
    }
}
