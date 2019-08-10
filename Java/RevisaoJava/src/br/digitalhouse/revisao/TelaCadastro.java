package br.digitalhouse.revisao;

import java.util.ArrayList;
import java.util.List;

public class TelaCadastro {

    public static void main(String[] args) {


        Data novaData = new Data(10, 8, 2019);

        Cliente novoCliente = new Cliente("João", novaData, 234);
        novoCliente.imprimeDados();

        System.out.println("**********************************************************");

        Funcionario novoFuncionario = new Funcionario("Maria", novaData, 10);
        novoFuncionario.calculaImposto();
        novoFuncionario.imprimeDados();

        System.out.println("**********************************************************");

        Gerente novoGerente = new Gerente("joao", novaData, 20, "Tecnologia");
        novoGerente.calculaImposto();
        novoGerente.imprimeDados();

        System.out.println("**********************************************************");

        CadastroPessoas novoCadastro = new CadastroPessoas();
        novoCadastro.cadastrarPessoa(novoCliente);
        novoCadastro.cadastrarPessoa(novoFuncionario);
        novoCadastro.cadastrarPessoa(novoGerente);
        novoCadastro.imprimeCadastro();


    }

}
