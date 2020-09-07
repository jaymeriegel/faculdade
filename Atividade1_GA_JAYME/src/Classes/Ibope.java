package Classes;

import Exceptions.ArrayNotPossibleException;

public class Ibope {

    private Candidato candidatoMaisBemColocadoBackEnd(Candidato[] arrayCandidatos, int finalArray, int inicioArray) throws ArrayNotPossibleException {
        if (arrayCandidatos == null){
            throw new ArrayNotPossibleException();
        }
        if (inicioArray == finalArray){
            return arrayCandidatos[inicioArray];
        }
        else {
            Candidato busca1;
            Candidato busca2;
            int metade;

            metade = (inicioArray + finalArray) / 2;
            busca1 = candidatoMaisBemColocadoBackEnd(arrayCandidatos, metade, inicioArray);
            busca2 = candidatoMaisBemColocadoBackEnd(arrayCandidatos, finalArray, metade + 1);

            if (busca1.getIntencoesDeVoto() > busca2.getIntencoesDeVoto()) return busca1;
            else return busca2;
        }
    }

    public Candidato candidatoMaisBemColocado(Candidato[] arrayCandidatos) throws ArrayNotPossibleException{
        return candidatoMaisBemColocadoBackEnd(arrayCandidatos, arrayCandidatos.length - 1, 0);
    }
}
