package Enumeracao;

public enum NumeroDoJogador {
    JOGADOR1, JOGADOR2;

    public char getCharJogador() {
        switch (this) {
            case JOGADOR1:
                return 'X';
            case JOGADOR2:
                return 'O';
            default:
                return 'N';
        }
    }
}
