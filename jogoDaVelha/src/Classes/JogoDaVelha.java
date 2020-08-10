package Classes;

import Enumeracao.NumeroDoJogador;

public class JogoDaVelha {
    private int tamanhoTabuleiro;
    private char[][] tabuleiro;

    public JogoDaVelha() {
        tabuleiro = new char[3][3];
    }

    public JogoDaVelha(int tamanhoTabuleiro) {
        tabuleiro = new char[tamanhoTabuleiro][tamanhoTabuleiro];
    }

    public boolean realizaJogada(int linha, int coluna, Jogador jogador) {
        if (tabuleiro[linha][coluna] == Character.MIN_VALUE) {
            if (jogador.getNumeroDoJogador().getCharJogador() == 'X') {
                tabuleiro[linha][coluna] = 'X';
            } else {
                tabuleiro[linha][coluna] = 'O';
            }
            return true;

        }
        return false;
    }


//    @Override
//    public String toString() {
//        return
//    }
}
