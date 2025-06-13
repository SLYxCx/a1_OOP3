package sorting;

import java.util.Comparator;

public class ShellSort {

    public static <T> void shellSort(T[] array, Comparator<? super T> comparator) {
        int n = array.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                T temp = array[i];
                int j = i;

                while (j >= gap && comparator.compare(array[j - gap], temp) < 0) {
                    array[j] = array[j - gap];
                    j -= gap;
                }

                array[j] = temp;
            }
        }
    }
    
    public static void shellSort(double[] array) {
        int n = array.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                double temp = array[i];
                int j = i;

                while (j >= gap && array[j - gap] < temp) {
                    array[j] = array[j - gap];
                    j -= gap;
                }

                array[j] = temp;
            }
        }
    }
}