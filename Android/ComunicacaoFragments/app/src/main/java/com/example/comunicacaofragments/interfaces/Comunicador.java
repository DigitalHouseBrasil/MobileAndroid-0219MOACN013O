package com.example.comunicacaofragments.interfaces;

import com.example.comunicacaofragments.model.SistemaOperacional;

public interface Comunicador {
    //Método que recebe como parametro um objeto do tipo SistemaOperacional
     void recebeMensagem(SistemaOperacional sistemaOperacional);
}
