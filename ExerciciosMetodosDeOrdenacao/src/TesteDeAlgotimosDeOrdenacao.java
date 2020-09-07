import java.util.Random;

public class TesteDeAlgotimosDeOrdenacao {

    public static void bubbleSort(int[] arrayInt) {

        int limite = arrayInt.length - 1;

        while (limite > 0) {
            int aux = 0;
            for (int i = 0; i < limite; i++) {
                if (arrayInt[i] > arrayInt[i + 1]) {
                    aux = arrayInt[i];
                    arrayInt[i] = arrayInt[i + 1];
                    arrayInt[i + 1] = aux;
                }
            }
            limite--;
        }
    }

    public static void insertionSort(int[] arrayInt) {

        int aux = 0;

        for (int i = 1; i < arrayInt.length; i++) {

            if (arrayInt[i] < arrayInt[i - 1]) {
                for (int j = i; j > 0; j--) {
                    if (arrayInt[j] < arrayInt[j - 1]) {
                        aux = arrayInt[j - 1];
                        arrayInt[j - 1] = arrayInt[j];
                        arrayInt[j] = aux;
                    }
                }
            }
        }

    }

    public static void selectSort(int[] arrayInt) {

        int aux;
        int position = 0;

        for (int i = 0; i < arrayInt.length; i++) {

            aux = arrayInt[i];

            for (int j = i; j < arrayInt.length; j++) {
                if (j == i) {
                    aux = arrayInt[j];
                    position = j;
                } else {
                    if (aux > arrayInt[j]) {
                        aux = arrayInt[j];
                        position = j;
                    }
                }
            }

            aux = arrayInt[i];
            arrayInt[i] = arrayInt[position];
            arrayInt[position] = aux;

        }

    }

    public static void main(String[] args) {

        // -------> Exercicio 1

        int[] array = new int[]{2, 7, 4, 9, 3};

        System.out.println("--- Bubble Sort");
        bubbleSort(array);
        for (int i : array) {
            System.out.println(i);
        }
        System.out.println();

        System.out.println("--- Insertion Sort");
        insertionSort(array);
        for (int i : array) {
            System.out.println(i);
        }
        System.out.println();

        System.out.println("--- Selection Sort");
        selectSort(array);
        for (int i : array) {
            System.out.println(i);
        }
        System.out.println();


        // -------> Exercicio 3
        // O Array em questão foi ordenado pelo Selection Sort.
        

        int[] arrayOrdemCrescente = new int[100000];
        int[] arrayOrdemDecrescente = new int[100000];
        int[] arrayOrdemAleatoria = new int[100000];

        for (int i = 0; i < arrayOrdemCrescente.length; i++) {
            arrayOrdemCrescente[i] = i;
        }

        for (int i = 0; i < arrayOrdemDecrescente.length; i++) {
            arrayOrdemDecrescente[i] = arrayOrdemDecrescente.length - i;
        }

        Random sorteio = new Random();
        for (int i = 0; i < arrayOrdemAleatoria.length; i++) {
            arrayOrdemAleatoria[i] = sorteio.nextInt(10000);
        }

        long tempoInicial = System.currentTimeMillis();

        selectSort(arrayOrdemAleatoria);

        long tempoFinal = System.currentTimeMillis();

        System.out.println((tempoFinal - tempoInicial) / 1000);


    }
}
