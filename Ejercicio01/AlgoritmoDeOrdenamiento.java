import java.util.Arrays;

public class AlgoritmoDeOrdenamiento {

    public static void print(String m) {
        System.out.println(m);
    }

    public static void main(String[] args) {
        int[][] casoPruebas = {
            {5, 3, 8, 2},
            {1, 2, 3, 4, 5},
            {5, 4, 3, 2, 1}
        };

        print("=== ANALISIS DE ALGORITMOS DE ORDENAMIENTO ===\n");

        for (int i = 0; i < casoPruebas.length; i++) {
            print("Caso de prueba " + (i + 1) + ": " + Arrays.toString(casoPruebas[i]));

            int[] arrBase = Arrays.copyOf(casoPruebas[i], casoPruebas[i].length);
            int[] arrOpt = Arrays.copyOf(casoPruebas[i], casoPruebas[i].length);
            int[] arrSel = Arrays.copyOf(casoPruebas[i], casoPruebas[i].length);

            // Llamadas a todos los algoritmos para ver la comparación
            bubbleSortBase(arrBase);
            BubbleSortOptimizado.sort(arrOpt);
            SelectionSort.sort(arrSel);

            print("--------------------------------------------------------------------------------");
        }
    }

    // Bubble Sort base
    public static void bubbleSortBase(int[] arr) {
        int n = arr.length;
        int comparaciones = 0;
        int intercambios = 0;

        for (int i = 0; i < n - 1; i++) {
            // El base compara todo (n-1), la mejora 2 es la que usa (n-i-1)
            for (int j = 0; j < n - 1; j++) {
                comparaciones++;
                if (arr[j] > arr[j + 1]) {
                    // Intercambio
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    intercambios++;
                }
            }
        }
        print("Bubble Sort Base   - Comparaciones: " + comparaciones + ", Intercambios: " + intercambios);
    }

    // Bubble Sort optimizado (Clase interna estática)
    static class BubbleSortOptimizado {
        public static void sort(int[] arr) {
            int n = arr.length;

            // Mejora 3: contador de operaciones
            int comparaciones = 0;
            int intercambios = 0;

            // Mejora 1: swapped
            boolean swapped;

            for (int i = 0; i < n - 1; i++) {
                swapped = false;
                
                // Mejora 2: j < n-i-1
                for (int j = 0; j < n - i - 1; j++) {
                    comparaciones++;
                    if (arr[j] > arr[j + 1]) {
                        // Intercambio
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        intercambios++;
                        swapped = true;
                    }
                }
                if (!swapped) {
                    break;
                }
            }
            print("Bubble Sort Opt.   - Comparaciones: " + comparaciones + ", Intercambios: " + intercambios);
        }
    }

    // Selection Sort (Clase interna estática)
    static class SelectionSort {
        public static void sort(int[] arr) {
            int n = arr.length;
            int comparaciones = 0;
            int intercambios = 0;

            for (int i = 0; i < n - 1; i++) {
                int minIdx = i;
                for (int j = i + 1; j < n; j++) {
                    comparaciones++;
                    if (arr[j] < arr[minIdx]) {
                        minIdx = j;
                    }
                }
                if (minIdx != i) {
                    int temp = arr[minIdx];
                    arr[minIdx] = arr[i];
                    arr[i] = temp;
                    intercambios++;
                }
            }
            print("Selection Sort     - Comparaciones: " + comparaciones + ", Intercambios: " + intercambios);
        }
    }
}