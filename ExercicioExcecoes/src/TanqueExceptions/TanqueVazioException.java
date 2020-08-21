package TanqueExceptions;

public class TanqueVazioException extends Exception {

    public TanqueVazioException(){
        super("Erro, carro esta com o tanque vazio");
    }
}
