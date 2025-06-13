package sorting;

public class SelectionSort {

public static void selectionSortMethod(double arr[]) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        int maxIndex = i;  
        for (int j = i + 1; j < n; j++) {
            if (arr[j] > arr[maxIndex]) {  
                maxIndex = j;
            }
        }
        
        double temp = arr[maxIndex];
        arr[maxIndex] = arr[i];
        arr[i] = temp;
    }
}

}
