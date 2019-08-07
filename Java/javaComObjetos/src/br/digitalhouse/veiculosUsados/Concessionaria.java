package br.digitalhouse.veiculosUsados;

import java.util.ArrayList;
import java.util.List;

public class Concessionaria {

    List<Venda> vendas = new ArrayList<>();

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public void registrarVenda(Carro carro, Cliente cliente, double valor) {
        Venda venda = new Venda();
        venda.setCarro(carro);
        venda.setCliente(cliente);
        venda.setValor(valor);

        this.vendas.add(venda);
    }

}
