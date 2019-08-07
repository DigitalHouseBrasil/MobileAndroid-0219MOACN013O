package br.digitalhouse.jogadoresTreinamento;

public class SessaoDeTreinamento {
    private int experiencia;

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public void treinarA(JogadorDeFutebol jogador) {
        System.out.println("Experiência antes do treino: " + jogador.getExperiencia());
        jogador.correr();
        jogador.fazerGol();
        jogador.correr();
        jogador.setExperiencia(jogador.getExperiencia() + 1);
        System.out.println("Experiência após o treino: " + jogador.getExperiencia());
    }
}
