package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    // Empty
    @Test
    void testEmptyArray() {
        int[] arr = {};
        PerformanceTracker t = new PerformanceTracker();
        InsertionSort.sort(arr, t);
        assertEquals(0, arr.length);
        assertEquals(0, t.comparisons);
        assertEquals(0, t.swaps);
    }

    // Single
    @Test
    void testSingleElement() {
        int[] arr = {10};
        PerformanceTracker t = new PerformanceTracker();
        InsertionSort.sort(arr, t);
        assertArrayEquals(new int[]{10}, arr);
    }

    // Duplicates
    @Test
    void testDuplicates() {
        int[] arr = {3, 1, 3, 2, 3};
        int[] expected = arr.clone();
        Arrays.sort(expected);
        PerformanceTracker t = new PerformanceTracker();
        InsertionSort.sort(arr, t);
        assertArrayEquals(expected, arr);
    }

    // Sorted
    @Test
    void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        PerformanceTracker t = new PerformanceTracker();
        InsertionSort.sort(arr, t);
        assertTrue(t.earlyTerminations >= 1);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    // Reverse
    @Test
    void testReverseOrder() {
        int[] arr = {9, 8, 7, 6, 5};
        int[] expected = arr.clone();
        Arrays.sort(expected);
        PerformanceTracker t = new PerformanceTracker();
        InsertionSort.sort(arr, t);
        assertArrayEquals(expected, arr);
        assertTrue(t.swaps > 0);
    }

    // Random
    @Test
    void testRandomArray() {
        Random rand = new Random(42);
        int[] arr = rand.ints(50, -100, 100).toArray();
        int[] expected = arr.clone();
        Arrays.sort(expected);
        PerformanceTracker t = new PerformanceTracker();
        InsertionSort.sort(arr, t);
        assertArrayEquals(expected, arr);
    }

    // Large
    @Test
    void testLargeArray() {
        Random rand = new Random(123);
        int[] arr = rand.ints(2000, -500, 500).toArray();
        int[] expected = arr.clone();
        Arrays.sort(expected);
        PerformanceTracker t = new PerformanceTracker();
        InsertionSort.sort(arr, t);
        assertArrayEquals(expected, arr);
    }
}
