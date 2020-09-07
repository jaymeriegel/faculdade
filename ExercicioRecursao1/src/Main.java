public class Main {

    // Exercicio 1
    public static int calculaSomaInteirosRecursao(int numero) {
        if (numero <= 1) return 1;
        else return numero + calculaSomaInteirosRecursao(numero - 1);
    }

    //Exercicio 2
    public static int somaVertorRecursiva(int vetorInt[], int tamanhoVetor) {
        if (tamanhoVetor <= 1) return vetorInt[tamanhoVetor - 1];
        else return vetorInt[tamanhoVetor - 1] + somaVertorRecursiva(vetorInt, tamanhoVetor - 1);
    }

    //Exercicio 3
    public static int mdc(int x, int y) {
        if ((x >= y) && (x % y == 0)) {
            return y;
        } else {
            if (x < y) {
                return mdc(y, x);
            } else {
                return mdc(y, x % y);
            }
        }
    }

    //Exercicio 4
    public static boolean achaCaractereNaString(String string, char caractere) {
        if (string.length() == 1) {
            return string.charAt(0) == caractere;
        } else {
            if (string.charAt(string.length() - 1) == caractere) {
                return true;
            } else {
                return achaCaractereNaString(string.substring(0, string.length() - 1), caractere);
            }
        }
    }

    //Exercicio 5
    public static void imprimeArrayAoContratio(int[] array, int tamanhoVetor) {
        if (tamanhoVetor == 1) {
            System.out.println(array[0]);
        } else {
            System.out.println(array[tamanhoVetor - 1]);
            imprimeArrayAoContratio(array, tamanhoVetor - 1);
        }
    }

    //Exercicio 6
    public static double somaArraysDeDouble(double[] array, int tamanhoVetor) {
        if (tamanhoVetor == 1) return 0;
        else return array[tamanhoVetor - 1] += somaArraysDeDouble(array, tamanhoVetor - 1);
    }

    //Exercicio 6
    public static double somaArraysDeDoubleBi(double[][] array, int numeroLinhas, int numeroColunas) {
        if (numeroLinhas == 0 && numeroColunas == 0) {
            return 0;
        } else {
            if (numeroColunas == 0) {
                return array[array.length - 1][array[0].length - 1] += somaArraysDeDoubleBi(array, numeroLinhas - 1, numeroColunas);
            } else {
                return array[array.length - 1][array[0].length - 1] += somaArraysDeDoubleBi(array, numeroLinhas, numeroColunas - 1);
            }
        }
    }

    public static int maximoR (int n, int v[]) {
        int x;
        if (n == 1) x = v[0];
        else {
            x = maximoR (n-1, v);
            if (x < v[n-1]) x = v[n-1];
        }
        return x;
    }

    //Exercicio 7
    public static int encontraPosicaoMenorValor(int[] array, int tamanhoVetor){

        int numero;

        if (tamanhoVetor == 0){
            numero = tamanhoVetor;
        } else {
            numero = encontraPosicaoMenorValor(array, tamanhoVetor - 1);
            if (array[numero] > array[tamanhoVetor - 1]) numero = tamanhoVetor - 1;
        }

        return numero;

    }

    //Exercicio 8
    private static void printPrimaryDiagonal(int[][] matriz, int tamanhoMatriz) throws MatrixNotPossibleException {
        if (matriz.length != matriz[0].length){
            throw new MatrixNotPossibleException();
        } else {
            if (tamanhoMatriz == 0){
                System.out.println(matriz[tamanhoMatriz][tamanhoMatriz]);
            } else {
                System.out.println(matriz[tamanhoMatriz][tamanhoMatriz]);
                printPrimaryDiagonal(matriz, tamanhoMatriz - 1);
            }
        }
    }

    public static void printPrimaryDiagonal(int[][] matriz){
        try {
            printPrimaryDiagonal(matriz, matriz.length - 1);
        } catch (MatrixNotPossibleException e) {
            e.printStackTrace();
        }
    }


    //Exercicio 9

    private static int binaryToDecimal(String binarioString, int tamanhoString, int potenciaInicial){

        if (tamanhoString == 1){
            if (binarioString.charAt(0) == '0'){
                return 0;
            } else {
                return (int) (Math.pow(2, potenciaInicial));
            }

        } else {

            if (binarioString.charAt(tamanhoString - 1) == '0'){
                return binaryToDecimal(binarioString, tamanhoString - 1, potenciaInicial + 1);
            } else {
                return (int) (Math.pow(2, potenciaInicial) + binaryToDecimal(binarioString, tamanhoString - 1, potenciaInicial + 1));
            }

        }
    }

    public static int binaryToDecimal(String binarioString){
        return binaryToDecimal(binarioString, binarioString.length(), 0);
    }

    public static void main(String[] args) {
        int[][] vetorTeste = new int[2][2];
        int[] vetorTesteInt = new int[]{0, -1, 40, 5, -50};

        for (int i = 0; i < vetorTeste.length; i++) {
            for (int j = 0; j < vetorTeste[0].length; j++) {
                vetorTeste[i][j] = 5;
            }
        }
        printPrimaryDiagonal(vetorTeste);

        char bi = '5';


        String iii = "11111111";

        System.out.println(binaryToDecimal(iii));
    }
}
