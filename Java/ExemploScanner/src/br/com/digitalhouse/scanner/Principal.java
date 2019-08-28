package br.com.digitalhouse.scanner;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner pegandoDados = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        //Pegando uma String com .next()
        String nome = pegandoDados.next();


        System.out.println("Digite sua idade: ");
        int idade = pegandoDados.nextInt();

        System.out.println("Olá "+nome+" sua idade é: "+idade

        );


    }

}
