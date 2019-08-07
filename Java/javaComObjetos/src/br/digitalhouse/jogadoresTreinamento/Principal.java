package br.digitalhouse.jogadoresTreinamento;

public class Principal {
    public static void main(String[] args) {
        JogadorDeFutebol jogador1 = new JogadorDeFutebol();
        jogador1.setNome("Jessica");
        jogador1.setExperiencia(2);
        jogador1.setAlegria(2);
        jogador1.setEnergia(10);
        jogador1.setGols(2);

        JogadorDeFutebol jogador2 = new JogadorDeFutebol();
        jogador2.setNome("Guilherme");
        jogador2.setExperiencia(4);
        jogador2.setAlegria(4);
        jogador2.setEnergia(5);
        jogador2.setGols(4);

        SessaoDeTreinamento treinamento = new SessaoDeTreinamento();
        treinamento.treinarA(jogador1);
        treinamento.treinarA(jogador2);
    }
}
