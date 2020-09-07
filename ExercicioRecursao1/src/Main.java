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

//    //Exercicio 7
//    public static int encontraPosicaoMenorValor(int[] array, int tamanhoArray){
//        if (tamanhoArray == 1){
//            return tamanhoArray - 1;
//        } else {
//            if ((tamanhoArray == 2) && (array[tamanhoArray - 1] > array[tamanhoArray - 2])){
//                return tamanhoArray - 1;
//            } else
//
//        }
//    } NAO CONSEGUI REALIZAR O EXERCICIO RECURSIVAMENTE.

    //Exercicio 8
//    public static void printPrimaryDiagonal(double[][] matriz) throws MatrixNotPossibleException {
//        if (matriz.length != matriz[0].length){
//            throw new MatrixNotPossibleException();
//        } else {
//            if (matriz.length == 1){
//                System.out.println(matriz[matriz.length - 1][matriz[0].length - 1]);
//            } else {
//
//            }
//        }
//    }
    //não consegui fazer recursivamente podendo haver somente 1 argumento.

    //Exercicio 9
//    public static int binaryToDecimal(String numeroBinario) {
//        int aa = numeroBinario.charAt(0);
//    }


    public static void main(String[] args) {
        double[][] vetorTeste = new double[2][2];

        for (int i = 0; i < vetorTeste.length; i++) {
            for (int j = 0; j < vetorTeste[0].length; j++) {
                vetorTeste[i][j] = 1;
            }
        }

        for (int i = 0; i < vetorTeste.length; i++) {
            for (int j = 0; j < vetorTeste[0].length; j++) {
                System.out.println(vetorTeste[i][j]);
            }
        }
        

    }
}
