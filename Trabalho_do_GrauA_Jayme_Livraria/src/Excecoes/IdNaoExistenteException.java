package Excecoes;

public class IdNaoExistenteException extends Exception {

    public IdNaoExistenteException() {
        super("Erro! ID nao existente no Estoque");
    }
}
