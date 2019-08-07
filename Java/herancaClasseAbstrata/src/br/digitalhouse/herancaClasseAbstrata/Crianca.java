package br.digitalhouse.herancaClasseAbstrata;

public class Crianca extends Pessoa {

    public Crianca(String novoNome, String novoSexo) {
        super(novoNome, novoSexo);
    }

    @Override
    public void respirar(String nome) {
        System.out.println("A pessoa está respirando" + nome);
    }


    @Override
    public boolean estudar(boolean status) {
        if (status){
            System.out.println("A criança está estudando! =)");
            return true;
        }else{
            System.out.println("Não tem ninguém estudando! =(");
            return false;
        }
    }

}
