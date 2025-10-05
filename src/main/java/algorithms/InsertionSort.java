package algorithms;

import metrics.PerformanceTracker;

public class InsertionSort {

    public static void sort(int[] arr, PerformanceTracker t) {
        if (arr == null || arr.length < 2) return;

        // Check if already sorted
        boolean sorted = true;
        for (int i = 1; i < arr.length; i++) {
            t.comparisons++;
            if (arr[i] < arr[i - 1]) {
                sorted = false;
                break;
            }
        }
        if (sorted) {
            t.earlyTerminations++;
            return;
        }

        // Standard Insertion Sort
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements greater than key one step ahead
            while (j >= 0) {
                t.comparisons++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    t.swaps++; // count as shift
                    j--;
                } else break;
            }
            arr[j + 1] = key;
        }
    }
}

