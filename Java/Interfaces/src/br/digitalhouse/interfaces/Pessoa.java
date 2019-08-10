package br.digitalhouse.interfaces;

public class Pessoa extends Animal implements Saudavel, Brincavel {

    public Pessoa(String novaRaca) {
        super(novaRaca);
    }

    @Override
    public void seDivertir() {

    }

    @Override
    public boolean animalSaudavel(String diagnostico) {
        return false;
    }

    @Override
    public int calculoIdadeAnimal(int idade) {
        return 0;
    }
}
