package metrics;

public class PerformanceTracker {
    public long comparisons = 0;
    public long swaps = 0;
    public long earlyTerminations = 0;
    public long runtimeNanos = 0;
    public long allocations = 0;


    public void reset() {
        comparisons = 0;
        swaps = 0;
        earlyTerminations = 0;
        runtimeNanos = 0;
        allocations = 0;
    }

    @Override
    public String toString() {
        return String.format("comparisons=%d, swaps=%d, earlyTerminations=%d, runtime=%dns, allocations=%d",
                comparisons, swaps, earlyTerminations, runtimeNanos, allocations);
    }
}
