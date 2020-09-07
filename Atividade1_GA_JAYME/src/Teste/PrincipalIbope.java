package Teste;

import Classes.Candidato;
import Classes.Ibope;
import Exceptions.ArrayNotPossibleException;

import java.util.Random;

public class PrincipalIbope {

    static Random sorteio = new Random();

    static char[] alfabeto = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'w', 'y', 'x', 'v'};

    public static String sorteiaNome() {
        String nome = "";
        int quantidadeDletras = sorteio.nextInt(6) + 1;
        for (int i = 0; i < quantidadeDletras; i++) {
            nome += alfabeto[sorteio.nextInt(alfabeto.length)];
        }
        return nome;
    }

    public static String sorteiaPartido() {
        String partido = "";
        int quantidadeDletras = sorteio.nextInt(3) + 1;
        for (int i = 0; i < quantidadeDletras; i++) {
            partido += alfabeto[sorteio.nextInt(alfabeto.length)];
        }
        return partido;
    }

    public static Candidato[] criaArrayCandidatos() {
        Candidato cadidatos[] = new Candidato[1000];
        cadidatos[0] = new Candidato("BRANCO", "BRANCO", 0);
        cadidatos[1] = new Candidato("NULO", "NULO", 0);
        for (int i = 2; i < 1000; i++) {
            cadidatos[i] = new Candidato(sorteiaNome(), sorteiaPartido(), 0);
        }
        return cadidatos;
    }

    public static void fazPesquisa(Candidato[] arrayDcandidatos) {
        for (int i = 0; i < 10000; i++) {
            int candidatoSelecionado = sorteio.nextInt(1000);
            arrayDcandidatos[candidatoSelecionado].somaPonto();
        }
    }

    public static void imprimeInfosCandidatos(Candidato[] arrayCandidatos) {
        for (int i = 0; i < arrayCandidatos.length; i++) {
            System.out.println("Candidato " + (i + 1) + " Nome: " + arrayCandidatos[i].getNome() + "| Partido: " + arrayCandidatos[i].getPartido() +
                    "| Quantidade de Votos: " + arrayCandidatos[i].getIntencoesDeVoto());
        }
    }

    public static void main(String[] args) {

        Candidato[] pesquisComCandidatos = criaArrayCandidatos();
        fazPesquisa(pesquisComCandidatos);
        imprimeInfosCandidatos(pesquisComCandidatos);
        Ibope ibope = new Ibope();
        System.out.println();
        try {
            System.out.println("Candidato mais bem colocado= NOME: " + ibope.candidatoMaisBemColocado(pesquisComCandidatos).getNome()
                    + " --PARTIDO: " + ibope.candidatoMaisBemColocado(pesquisComCandidatos).getPartido() + " --Pontos: " + ibope.candidatoMaisBemColocado(pesquisComCandidatos).getIntencoesDeVoto());
        } catch (ArrayNotPossibleException e) {
            e.printStackTrace();
        }


    }
}
