package cli;

import algorithms.InsertionSort;
import metrics.PerformanceTracker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Arrays;

public class BenchmarkRunner {

    public static void main(String[] args) throws IOException {
        int[] sizes;
        if (args.length > 0) {
            sizes = Arrays.stream(args).mapToInt(Integer::parseInt).toArray();
        } else {
            sizes = new int[]{100, 1000, 5000, 10000};
        }

        try (FileWriter out = new FileWriter("results_insertion_sort.csv")) {
            out.write("n;runtime_ns;comparisons;swaps;earlyTerminations;allocations\n");

            for (int n : sizes) {
                int[] arr = new Random(42).ints(n, -10000, 10000).toArray();
                PerformanceTracker tracker = new PerformanceTracker();

                long start = System.nanoTime();
                InsertionSort.sort(arr, tracker);
                long end = System.nanoTime();

                tracker.runtimeNanos = end - start;

                out.write(String.format("%d;%d;%d;%d;%d;%d%n",
                        n, tracker.runtimeNanos, tracker.comparisons, tracker.swaps,
                        tracker.earlyTerminations, tracker.allocations));
            }
        }
    }
}
