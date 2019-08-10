package br.digitalhouse.interfaces;

public class Cachorro extends Animal implements Saudavel {

    public Cachorro(String novaRaca) {
        super(novaRaca);
    }

    @Override
    public boolean animalSaudavel(String diagnostico) {

        if(diagnostico != null && diagnostico != ""){

            System.out.println("O cachorro "+ getRaca() + "\n está com o seguinte diagnostico: "+diagnostico);
            return true;

        }else{

            System.out.println("Não possui diagnostico");
            return false;
        }
    }

    @Override
    public int calculoIdadeAnimal(int novaIdade) {
        System.out.println("Estamos somando as idades!");
        return getIdade() + novaIdade;
    }

    @Override
    public void seDivertir() {
        System.out.println("O cachorro está se divertindo");
    }
}
