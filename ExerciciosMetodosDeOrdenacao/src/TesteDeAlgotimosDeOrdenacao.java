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

        int[] array = new int[]{-1, -3, 0, 101, 2, 7, 4, 9, 3, 1, 10, 1, 100, 15};

        selectSort(array);

        for (int i : array) {
            System.out.println(i);
        }


    }
}
