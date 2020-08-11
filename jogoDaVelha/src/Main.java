import Classes.Jogador;
import Enumeracao.NumeroDoJogador;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("Bem vindo ao Jogo Da Velha");
            System.out.println("1 ---> Jogar");
            System.out.println("2 ---> Sair");

            System.out.print("Selecione: ");
            int opcao = sc.nextInt();
            System.out.println();

            if (opcao == 1) {

                String nomePlayer1;
                String nomePlayer2;

                nomePlayer1 = sc.nextLine();


            } else {
                if (opcao == 2) {
                    System.out.println("Obrigado por Jogar!");
                    break;
                } else {
                    System.out.println("OPCAO INVALIDA!");
                }
            }


        }


    }

}
