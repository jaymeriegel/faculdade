package Classes;

import java.util.Arrays;

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

    public boolean verificaGanhador() {

        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[0].length; j++) {
                if (tabuleiro[i][j] != Character.MIN_VALUE) {

                    if (verificaColuna(i, j) || verificaDiagonalInversa(i, j)
                            || verificaDiagonalPrincipal(i, j) || verificaLinhas(i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean verificaLinhas(int linha, int coluna) {

        for (int i = 0; i < tabuleiro[0].length; i++) {
            if (tabuleiro[linha][i] != tabuleiro[linha][coluna]) {
                return false;
            }
        }
        return true;
    }

    public boolean verificaColuna(int linha, int coluna) {

        for (int i = 0; i < tabuleiro[0].length; i++) {
            if (tabuleiro[i][coluna] != tabuleiro[linha][coluna]) {
                return false;
            }
        }
        return true;
    }

    public boolean verificaDiagonalPrincipal(int linha, int coluna) {

        if (linha != coluna) {
            return false;
        }
        for (int i = 0; i < tabuleiro.length; i++) {
            if (tabuleiro[i][i] != tabuleiro[linha][coluna])
                return false;
        }
        return true;
    }

    public boolean verificaDiagonalInversa(int linha, int coluna) {

        if ((linha + coluna) != (tabuleiro.length - 1)) {
            return false;
        }

        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[0].length; j++) {
                if ((i + j) == (tabuleiro.length - 1)) {
                    if (tabuleiro[i][j] != tabuleiro[linha][coluna]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {

        String estadoTabuleiro = "";

        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[0].length; j++) {
                if (tabuleiro[i][j] == Character.MIN_VALUE) {
                    estadoTabuleiro += "  |";
                } else {
                    estadoTabuleiro += " " + tabuleiro[i][j] + "|";
                }
            }
            estadoTabuleiro += "\n";
        }

        return estadoTabuleiro;
    }
}
