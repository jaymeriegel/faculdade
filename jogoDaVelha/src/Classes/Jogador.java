package Classes;

import Enumeracao.NumeroDoJogador;

public class Jogador {
    private String nome;
    private int quantidadeDePontos;
    private NumeroDoJogador numeroDoJogador;
    private static int contagemDeJogadores = 0;

    public Jogador(String nome) {
        this.nome = nome;
        this.quantidadeDePontos = 0;
        if (contagemDeJogadores == 0){
            this.numeroDoJogador = NumeroDoJogador.JOGADOR1;
        }else {
            this.numeroDoJogador = NumeroDoJogador.JOGADOR2;
        }
        contagemDeJogadores ++;
    }

    public NumeroDoJogador getNumeroDoJogador() {
        return numeroDoJogador;
    }

    public void setNumeroDoJogador(NumeroDoJogador numeroDoJogador) {
        this.numeroDoJogador = numeroDoJogador;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeDePontos() {
        return quantidadeDePontos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidadeDePontos(int quantidadeDePontos) {
        this.quantidadeDePontos = quantidadeDePontos;
    }

    @Override
    public String toString() {
        return "Jogador" + "\n" +
                "Nome: " + nome + "\n" +
                "Quantidade De Pontos: " + quantidadeDePontos;
    }
}
