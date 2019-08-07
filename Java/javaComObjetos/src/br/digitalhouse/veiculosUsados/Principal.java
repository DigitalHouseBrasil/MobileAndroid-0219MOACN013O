package br.digitalhouse.veiculosUsados;

public class Principal {

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNome("José");
        cliente.setSobrenome("da Silva");
        cliente.setContato("11-91234-5678");

        Carro carro = new Carro();
        carro.setMarca("Bugatii");
        carro.setModelo("Veyron Super Sport");
        carro.setFabricacao(2015);
        carro.setQuilometragem(1500);

        Concessionaria concessionaria = new Concessionaria();
        concessionaria.registrarVenda(carro, cliente, 8512500.0);
    }

}
