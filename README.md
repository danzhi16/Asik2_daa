# InsertionSort

A simple Java implementation of the Insertion Sort algorithm with a tiny CLI benchmark and basic performance metrics (comparisons, shifts, early terminations, runtime). The benchmark writes results to a CSV file for easy analysis.

- Language: Java
- Build tool: Maven
- Tests: JUnit 5


## Usage

Prerequisites
- Java 17+
- Maven 3.9+

Build and run tests
- Compile and run unit tests:
    - mvn -q verify

Run the CLI benchmark
- The CLI accepts a list of input sizes (n). For each size it generates a random array, sorts it using insertion sort, and writes lines to results_insertion_sort.csv (one line per size).
    - mvn -q compile exec:java -Dexec.mainClass="cli.BenchmarkRunner" -Dexec.args="100 1000 5000"
- If no sizes are provided, it defaults to 100, 1000, 5000, 10000.
- Output file: results_insertion_sort.csv (note: the file is overwritten on each run)
- CSV header:
    - n;runtime_ns;comparisons;swaps;earlyTerminations;allocations

Notes
- The CLI does not print to the console; it writes only to the CSV file.
- Random numbers are generated with a fixed seed (42) for reproducible inputs per size in a single run.


## Project structure
- src/main/java/algorithms/InsertionSort.java — sorting algorithm implementation
- src/main/java/metrics/PerformanceTracker.java — counters for performance metrics
- src/main/java/cli/BenchmarkRunner.java — CLI that runs benchmarks and writes CSV
- src/test/java/algorithms/InsertionSortTest.java — unit tests for algorithm correctness


## Complexity analysis

Insertion Sort (classic implementation with element shifting):
- Time complexity:
    - Best case: O(n) when the array is already sorted. This implementation detects sorted input up front and stops early.
    - Average case: O(n^2) due to roughly n^2/4 comparisons/shifts on random input.
    - Worst case: O(n^2), e.g., when the array is in reverse order.
- Space complexity: O(1) additional space (in-place, uses a small constant amount of extra memory).
- Stability: Stable — equal elements preserve relative order because we only shift when arr[j] > key.


## Metrics captured
- comparisons: Number of element comparisons performed.
- swaps: Number of element shifts (counted as swaps) performed.
- earlyTerminations: Count of times the algorithm detected an already-sorted array and exited early.
- runtime_ns: Wall-clock time for the sort in nanoseconds (measured around the call in the CLI).
- allocations: Placeholder counter (currently unused in the algorithm; always 0 unless you instrument it).


## Continuous Integration
GitHub Actions workflow compiles, runs tests, executes the benchmark, and uploads the generated CSV as a build artifact.


## Troubleshooting
- If Maven fails due to Java version mismatch, ensure you are using Java 17 or adjust the Maven compiler settings in pom.xml accordingly.
- If exec:java fails, ensure you have internet access to download the Maven Exec Plugin, or declare it explicitly in your pom.xml.
