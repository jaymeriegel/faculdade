public class Exercicios {

    //exercicio 1
    private static boolean verificaInteiroNoArray(int[] arrayInt, int numero, int tamanhoDoArray) {
        if (tamanhoDoArray == 1) {
            return arrayInt[tamanhoDoArray - 1] == numero;
        } else {
            if (arrayInt[tamanhoDoArray - 1] == numero) {
                return true;
            } else {
                return verificaInteiroNoArray(arrayInt, numero, tamanhoDoArray - 1);
            }
        }
    }

    public static boolean exericio1(int[] arrayInt, int numero) {
        return verificaInteiroNoArray(arrayInt, numero, arrayInt.length);
    }

    //exercicio 2

    private static boolean verificaIntPrimo(int numero, int metadeNumero) {
        if (numero == 2){
            return true;
        } else {
            if (numero == 0 || numero == 1){
                return false;
            } else {
                if (metadeNumero < 2){
                    return true;
                } else {
                    if (numero % metadeNumero == 0){
                        return false;
                    } else {
                        return verificaIntPrimo(numero, metadeNumero - 1);
                    }
                }
            }
        }
    }

    public static boolean exercicio2(int primo) {
        int parteInteira = (int)primo / 2;
        return verificaIntPrimo(primo, parteInteira);
    }

    //exercicio3

    private static void selectionSort(int arrayInteiros[], int tamanhoArray, int valorInicialPosition, int valorInicialArray){
        if (valorInicialPosition < tamanhoArray){
            if (valorInicialArray )
        }
    }


    {5, 10, 30, 1}

}
