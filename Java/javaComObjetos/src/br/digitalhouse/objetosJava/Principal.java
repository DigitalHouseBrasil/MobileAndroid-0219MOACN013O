package br.digitalhouse.objetosJava;

public class Principal {

    public static void main(String[] args) {

        Animal animalMamifero = new Animal("Bidu");

        animalMamifero.setNomeAnimal("Lulu");

        System.out.println(animalMamifero.getNomeAnimal());
//        System.out.println(animalMamifero.raca);
//        System.out.println(animalMamifero.cor);
//        System.out.println(animalMamifero.idade);
//
        Animal animalDomestico = new Animal();

        animalDomestico.setNomeAnimal("Ted");
        System.out.println(animalDomestico.getNomeAnimal());

        System.out.println("*******************************************************");

        //Criando um novo objeto
        Pessoa pessoaJovem = new Pessoa("Erika");

        //Mostrando o nome do objeto pessoaJovem
        System.out.println(pessoaJovem.getNomePessoa());

        //Setando o objeto pessoaJovem pelo metodo set
        animalDomestico.setDonoAnimal(pessoaJovem);

        //mostrando o nome do dono do animal a partir do objeto animalDomestico
        System.out.println(animalDomestico.getDonoAnimal().getNomePessoa());

        //Criando um novo objeto do tipo Pessoa
        Pessoa pessoaIdosa = new Pessoa("Clotilde");

        //Atribuindo uma nova pessoa através do método set
        animalDomestico.setDonoAnimal(pessoaIdosa);

    }

}
