package TanqueExceptions;

public class TanqueCheioException extends Exception {

    public TanqueCheioException(){
        super("Tanque já está cheio! Nao pode abastecer mais!");
    }
}
