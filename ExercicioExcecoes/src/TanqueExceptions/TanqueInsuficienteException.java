package TanqueExceptions;

public class TanqueInsuficienteException extends Exception {

    public TanqueInsuficienteException() {
        super("Erro! carro nao tem tanque com capacidade suficiente para alcancar o local!");
    }
}
