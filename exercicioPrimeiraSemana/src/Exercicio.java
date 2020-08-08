import java.util.Scanner;
import java.util.Random;

public class Exercicio {

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

    public static int retornaQuant(Double[][] arrayBidimensional) {
        return arrayBidimensional.length * arrayBidimensional[0].length;
    }

    // ------------- 5

    // ------------- 6

    public static String retornaMatrizEmString(Double[][] arrayBidimensional) {
        String saida = "";

        for (int i = 0; i < arrayBidimensional.length; i++) {
            for (int j = 0; j < arrayBidimensional[0].length; j++) {
                if (j + 1 == arrayBidimensional[0].length)
                    saida += String.valueOf(arrayBidimensional[i][j]);
                else
                    saida += String.valueOf(arrayBidimensional[i][j]) + " - ";
            }
            saida += "\n";
        }

        return saida;
    }

    // ------------- 7

    public static double retornaMaior(Double[][] arrayBidimensional) {
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


    public static void main(String[] args) {

        Double[][] matrizDouble = new Double[2][5];

        System.out.println(retornaMatrizEmString(matrizDouble));


    }
}
