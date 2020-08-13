import Classes.Jogador;
import Classes.JogoDaVelha;
import Enumeracao.NumeroDoJogador;

import java.util.Scanner;


public class Main {

    static Scanner sc = new Scanner(System.in);
    static JogoDaVelha tabuleiro = new JogoDaVelha();

    public static void main(String[] args) {

        while (true) {

            System.out.println("Bem vindo ao Jogo Da Velha");
            System.out.println("1 ---> Jogar");
            System.out.println("2 ---> Sair");

            System.out.print("Selecione: ");
            int opcao = sc.nextInt();
            System.out.println();

            if (opcao == 1) {

                System.out.print("Digite o nome do jogador 1: ");
                String player1 = sc.nextLine();
                sc.nextLine();
                System.out.println("Jogador 1 joga com X");

                System.out.print("Digite o nome do jogador 2: ");
                String player2 = sc.nextLine();
                System.out.println("Jogador 2 joga com O");

                Jogador p1 = new Jogador(player1);
                Jogador p2 = new Jogador(player2);

                System.out.println();

                while (true) {
                    System.out.println("-- Tamanho do Tabuleiro --");
                    System.out.println("1 ---> Padrao (3 x 3)");
                    System.out.println("2 ---> Medio (5 x 5)");
                    System.out.println("3 ---> Grande (7 x 7)");
                    System.out.println("4 ---> Personalizado");
                    System.out.print("Selecione: ");
                    int opcTabuleiro = sc.nextInt();

                    if (opcTabuleiro == 1) {
                        tabuleiro.setTamanhoTabuleiro(3);
                        break;
                    } else {
                        if (opcTabuleiro == 2) {
                            tabuleiro.setTamanhoTabuleiro(5);
                            break;
                        } else {
                            if (opcTabuleiro == 3) {
                                tabuleiro.setTamanhoTabuleiro(7);
                                break;
                            } else {
                                if (opcTabuleiro == 4) {
                                    System.out.print("Selecione o tamanho: ");
                                    int tamanhoTabuleiro = sc.nextInt();
                                    tabuleiro.setTamanhoTabuleiro(tamanhoTabuleiro);
                                    break;
                                } else {
                                    System.out.println("Opcao Invalida!");
                                    System.out.println();
                                }
                            }
                        }
                    }
                }

                System.out.println("O tabuleiro foi criado iniciado: ");
                System.out.println(tabuleiro);

                System.out.println();

                boolean naoPrimeiraJogada = false;
                int contaJogadas = 0;
                boolean jogoTerminou = false;
                boolean sairDoJogo = false;
                boolean jogadaReal;
                boolean pula;

                while (true) {


                    if (naoPrimeiraJogada && jogoTerminou) {

                        tabuleiro.clenTabuleiro();

                        System.out.println("--- Pontuacao Atual ---");
                        System.out.println("Jogador 1 ---> " + p1.getQuantidadeDePontos());
                        System.out.println("Jogador 2 ---> " + p2.getQuantidadeDePontos());
                        System.out.println();

                        while (true) {

                            System.out.println("Jogar mais 1 vez --- 1");
                            System.out.println("Fechar Jogo -------- 2");
                            System.out.print("Selecione: ");
                            int optContinuarJogo = sc.nextInt();

                            System.out.println();

                            if (optContinuarJogo == 1) {
                                System.out.println("Vamos Jogar!");
                                break;
                            } else {
                                if (optContinuarJogo == 2) {

                                    if (p1.getQuantidadeDePontos() > p2.getQuantidadeDePontos()) {
                                        System.out.println("Parabens Jogador 1 venceu!");
                                        sairDoJogo = true;
                                        break;
                                    } else {
                                        if (p1.getQuantidadeDePontos() < p2.getQuantidadeDePontos()) {
                                            System.out.println("Parabens Jogador 2 venceu!");
                                            sairDoJogo = true;
                                            break;
                                        } else {
                                            System.out.println("O jogo acabou sem ganhadores!");
                                            sairDoJogo = true;
                                            break;
                                        }
                                    }
                                } else {
                                    System.out.println("Erro opcao invalida");
                                }
                            }
                        }
                    }

                    if (sairDoJogo) {
                        break;
                    }

                    jogoTerminou = false;

                    // jogador 1 começa
                    while (true) {

                        if (jogoTerminou == true) {
                            break;
                        }

                        pula = false;

                        jogadaReal = false;

                        System.out.println("11111");
                        System.out.println("Jogador 1 faca a sua jogada...");
                        System.out.print("linha..: ");
                        int jogadaLinha = sc.nextInt();
                        System.out.print("coluna..: ");
                        int jogadaColuna = sc.nextInt();


                        if (tabuleiro.verificaJogadaDentro(jogadaLinha, jogadaColuna)) {
                            jogadaReal = true;
                        }

                        // valida jogada do jogador 1
                        if (jogadaReal && tabuleiro.validaJogada(jogadaLinha, jogadaColuna)) {
                            tabuleiro.realizaJogada(jogadaLinha, jogadaColuna, p1);

                            pula = true;

                            System.out.println();
                            System.out.println(tabuleiro);

                            // verifica se o jogador 1 ganhou
                            if (tabuleiro.verificaGanhador()) {
                                System.out.println("PARABENS! " + p1.getNome() + " VOCE GANHOU!");
                                p1.somaPonto();
                                jogoTerminou = true;
                                naoPrimeiraJogada = true;
                                break;
                            }

                            // verifica se o jogo terminou
                            if (tabuleiro.verificaEndGame()) {
                                System.out.println("O JOGO TERMINOU EMPATADO!");
                                jogoTerminou = true;
                                naoPrimeiraJogada = true;
                                break;
                            }

                        } else {
                            System.out.println("Jogada Invalida, posicao ja ocupada... Tente novamente!");
                        }

                        if (pula) {
                            contaJogadas++;
                            break;
                        }


                    }

                    while (true) {

                        if (jogoTerminou == true) {
                            break;

                        } else {

                            pula = false;

                            jogadaReal = false;

                            //
                            System.out.println("2222222");
                            System.out.println("Jogador 2 faca a sua jogada...");
                            System.out.print("linha..: ");
                            int jogadaLinha2 = sc.nextInt();
                            System.out.print("coluna..: ");
                            int jogadaColuna2 = sc.nextInt();

                            if (tabuleiro.verificaJogadaDentro(jogadaLinha2, jogadaColuna2)) {
                                jogadaReal = true;
                            }

                            if (jogadaReal && tabuleiro.validaJogada(jogadaLinha2, jogadaColuna2)) {
                                tabuleiro.realizaJogada(jogadaLinha2, jogadaColuna2, p2);

                                pula = true;

                                System.out.println();
                                System.out.println(tabuleiro);

                                if (tabuleiro.verificaGanhador()) {
                                    System.out.println("PARABENS! " + p2.getNome() + " VOCE GANHOU!");
                                    p2.somaPonto();
                                    jogoTerminou = true;
                                    naoPrimeiraJogada = true;
                                    break;

                                } else {
                                    if (tabuleiro.verificaEndGame()) {
                                        System.out.println("O JOGO TERMINOU EMPATADO!");
                                        naoPrimeiraJogada = true;
                                        jogoTerminou = true;
                                        break;
                                    }
                                }

                            } else {
                                System.out.println("Jogada Invalida, posicao ja ocupada... Tente novamente!");
                            }

                            if (pula) {
                                break;
                            }

                        }

                    }

                }

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
