package Exceptions;

public class ArrayNotPossibleException extends Exception {

    public ArrayNotPossibleException(){
        System.err.println("Erro, Array esta vazio!");
    }
}
