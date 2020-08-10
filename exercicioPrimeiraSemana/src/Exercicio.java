import java.util.Scanner;
import java.util.Random;

public class Exercicio {


    static double[][] matrizExDouble = new double[5][5];

    static {
        Random sorteioEx = new Random();
        for (int i = 0; i < matrizExDouble.length; i++) {
            for (int j = 0; j < matrizExDouble[0].length; j++) {
                matrizExDouble[i][j] = sorteioEx.nextInt(100);
            }

        }
    }

    static int[][] matrizExInt = new int[5][5];

    static {
        Random sorteioEx = new Random();
        for (int i = 0; i < matrizExInt.length; i++) {
            for (int j = 0; j < matrizExInt[0].length; j++) {
                matrizExInt[i][j] = sorteioEx.nextInt(100);
            }

        }
    }

    static Scanner sc = new Scanner(System.in);

    // ------------- 1

    public static void exercicio1a() {
        Integer[][] arrayLine = new Integer[3][10];

        for (int i = 0; i < arrayLine.length; i++) {
            for (int j = 0; j < arrayLine[i].length; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void exercicio1b() {
        Integer[][] arrayQuadrados = new Integer[5][10];

        for (int i = 0; i < arrayQuadrados.length; i++) {
            for (int j = 0; j < arrayQuadrados[i].length; j++) {
                System.out.print(j * j + " ");
            }
            System.out.println();
        }
    }

    public static void exercicio1c() {
        Integer[][] array36 = new Integer[6][6];

        for (int i = 0; i < array36.length; i++) {
            for (int j = 0; j < array36[i].length; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void exercicio1d() {
        Integer[][] array01 = new Integer[6][9];

        for (int i = 0; i < array01.length; i++) {
            for (int j = 0; j < array01[i].length; j++) {
                if (i % 2 == 0)
                    System.out.print("-1 ");
                else
                    System.out.print(" 0 ");
            }
        }
        System.out.println();
    }


    // ------------- 2

    public static void inteirosAleatorios() {
        System.out.print("Digite o tamanho da linha: ");
        int line = sc.nextInt();
        System.out.print("Digite o tamanho da coluna: ");
        int colums = sc.nextInt();

        Integer[][] matrizAleatoria = new Integer[line][colums];
        Random sorteio = new Random();

        for (int i = 0; i < matrizAleatoria.length; i++) {
            for (int j = 0; j < matrizAleatoria[i].length; j++) {
                int numeroSorteado = sorteio.nextInt(100);
                if (numeroSorteado < 10)
                    System.out.print(" ");

                System.out.print(numeroSorteado + " ");
            }
            System.out.println();
        }
    }

    // ------------- 3

    public static void matrizDouble() {
        Double[][] matrizDouble = new Double[2][5];
        System.out.println("Digite os 10 numeros da matriz: ");
        int contador = 1;

        for (int i = 0; i < matrizDouble.length; i++) {
            for (int j = 0; j < matrizDouble[0].length; j++) {
                System.out.print(contador + "°: ");
                matrizDouble[i][j] = sc.nextDouble();
                contador++;
            }
        }

        for (int i = 0; i < matrizDouble.length; i++) {
            for (int j = 0; j < matrizDouble[0].length; j++) {
                System.out.print(matrizDouble[i][j] + "|");
            }
            System.out.println();
        }
    }

    // ------------- 4

    public static int retornaQuant(double[][] arrayBidimensional) {
        return arrayBidimensional.length * arrayBidimensional[0].length;
    }

    // ------------- 5

    // ------------- 6

    public static String retornaMatrizEmString(double[][] arrayBidimensional) {
        String saida = "";

        for (int i = 0; i < arrayBidimensional.length; i++) {
            for (int j = 0; j < arrayBidimensional[0].length; j++) {
                if (j + 1 == arrayBidimensional[0].length)
                    saida += String.valueOf(arrayBidimensional[i][j]);
                else
                    saida += arrayBidimensional[i][j] + " - ";
            }
            saida += "\n";
        }

        return saida;
    }

    // ------------- 7

    public static double retornaMaior(double[][] arrayBidimensional) {
        double maior = 0;

        for (int i = 0; i < arrayBidimensional.length; i++) {
            for (int j = 0; j < arrayBidimensional[0].length; j++) {
                if (i == 0 && j == 0) {
                    maior = arrayBidimensional[i][j];
                } else {
                    if (arrayBidimensional[i][j] > maior) {
                        maior = arrayBidimensional[i][j];
                    }
                }
            }
        }
        return maior;
    }

    // ------------- 8

    public static int retornaSoma(int[][] matizInt) {

        int somaMatriz = 0;

        for (int i = 0; i < matizInt.length; i++) {
            for (int j = 0; j < matizInt[0].length; j++) {
                somaMatriz += matizInt[i][j];
            }
        }

        return somaMatriz;
    }

    // ------------- 9

    public static double retornaMedia(double[][] arrayBidimensional) {

        double soma = 0;

        for (int i = 0; i < arrayBidimensional.length; i++) {
            for (int j = 0; j < arrayBidimensional[0].length; j++) {
                soma += arrayBidimensional[i][j];
            }
        }

        return soma / (arrayBidimensional.length * arrayBidimensional[0].length);

    }

    // ------------- 10

    public static void matrizChar() {

        Random sorteio = new Random();
        char[][] matrizChars = new char[sorteio.nextInt(5) + 1][sorteio.nextInt(3) + 1];
        int contagem = 1;

        for (int i = 0; i < matrizChars.length; i++) {
            for (int j = 0; j < matrizChars[0].length; j++) {
                System.out.print(contagem + "º char: ");
                matrizChars[i][j] = sc.next().charAt(0);
                contagem++;
            }
        }

        for (int i = 0; i < matrizChars.length; i++) {
            for (int j = 0; j < matrizChars[0].length; j++) {
                System.out.print(matrizChars[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(matrizChars.length + "...." + matrizChars[0].length);

    }

    // ------------- 11

    public static void retornaPositivos(int[][] matrizInteiros) {

        int contagemPositivos = 0;
        int contagemArrayUni = 0;

        for (int i = 0; i < matrizInteiros.length; i++) {
            for (int j = 0; j < matrizInteiros[0].length; j++) {
                if (matrizInteiros[i][j] > 0) {
                    contagemPositivos++;
                }
            }
        }

        int[] arrayUniPositivo = new int[contagemPositivos];

        for (int i = 0; i < matrizInteiros.length; i++) {
            for (int j = 0; j < matrizInteiros[0].length; j++) {
                if (matrizInteiros[i][j] > 0) {
                    arrayUniPositivo[contagemArrayUni] = matrizInteiros[i][j];
                    contagemArrayUni++;
                }
            }
        }

        for (int i = 0 ; i < contagemPositivos; i++){
            System.out.print(arrayUniPositivo[i] + " ");
        }

    }

    public static void menuEx1() {

        int opcao = 30;

        do {

            System.out.println("---- Exercicio 1 ----");
            System.out.println("ex a -- 1");
            System.out.println("ex b -- 2");
            System.out.println("ex c -- 3");
            System.out.println("ex d -- 4");
            System.out.println("sair -- 5");

            System.out.print("Digite a opcao:... ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    exercicio1a();
                    break;

                case 2:
                    exercicio1b();
                    break;

                case 3:
                    exercicio1c();
                    break;

                case 4:
                    exercicio1d();
                    break;

                case 5:
                    break;

                default:
                    System.err.println("selecione uma opcao correta");
            }

        } while (opcao != 5);


    }

    public static void menu() {

        int opcao = 30;

        do {

            System.out.println("---- Menu do Exercicio ----");
            System.out.println("ex 1");
            System.out.println("ex 2");
            System.out.println("ex 3");
            System.out.println("ex 4");
            System.out.println("ex 5");
            System.out.println("ex 6");
            System.out.println("ex 7");
            System.out.println("ex 8");
            System.out.println("ex 9");
            System.out.println("ex 10");
            System.out.println("ex 11");
            System.out.println("12 PARA SAIR");
            System.out.println();
            System.out.print("Digite a opcao:... ");

            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    menuEx1();
                    System.out.println("--------------");
                    break;

                case 2:
                    inteirosAleatorios();
                    System.out.println("--------------");
                    break;

                case 3:
                    matrizDouble();
                    System.out.println("--------------");
                    break;

                case 4:
                    System.out.println(retornaQuant(matrizExDouble));
                    System.out.println("--------------");
                    break;

                case 5:
                    System.out.println("digite outra opcao");
                    System.out.println("--------------");
                    break;

                case 6:
                    System.out.println(retornaMatrizEmString(matrizExDouble));
                    System.out.println("--------------");
                    break;

                case 7:
                    System.out.println(retornaMaior(matrizExDouble));
                    System.out.println("--------------");
                    break;

                case 8:
                    System.out.println(retornaSoma(matrizExInt));
                    System.out.println("--------------");
                    break;

                case 9:
                    System.out.println(retornaMedia(matrizExDouble));
                    System.out.println("--------------");
                    break;

                case 10:
                    matrizChar();
                    System.out.println("--------------");
                    break;

                case 11:
                    retornaPositivos(matrizExInt);
                    System.out.println("--------------");
                    break;

                case 12:
                    break;

                default:
                    System.out.println("escolha uma opcao disponivel");
                    System.out.println("--------------");
                    break;

            }

        } while (opcao != 12);
    }

    // ------------- 12

    public static void main(String[] args) {
        menu();
    }
}
