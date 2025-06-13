package sorting;

public class QuickSort {

    public static void quickSortMethod(double arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSortMethod(arr, low, pi - 1);
            quickSortMethod(arr, pi + 1, high);
        }
    }

    public static int partition(double arr[], int low, int high) {
    double pivot = arr[high];
    int i = (low - 1);
    for (int j = low; j < high; j++) {
        if (arr[j] > pivot) {  
            i++;
            double temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    double temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    return i + 1;
}
}
