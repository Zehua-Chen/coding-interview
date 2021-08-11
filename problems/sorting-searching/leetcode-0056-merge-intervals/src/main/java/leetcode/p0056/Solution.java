package leetcode.p0056;

import java.util.*;

public class Solution {
    // Guaranttee as a result of sorting: a[0] <= b[0]
    private boolean overlaps(int[] a, int[] b) {
        return a[0] <= b[0] && b[0] <= a[1];
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]));

        var merged = new ArrayList<int[]>();
        merged.add(intervals[0]);

        for (int[] interval : intervals) {
            int[] base = merged.get(merged.size() - 1);

            if (overlaps(base, interval)) {
                base[1] = Math.max(base[1], interval[1]);
            } else {
                merged.add(interval);
            }
        }

        return merged.toArray(new int[0][]);
    }
}
