package leetcode.p0057;

import java.util.*;

/** Runtime: O(N log N) Space: O(N) */
public class BaselineSolution {
    private List<int[]> insertSorted(int[][] intervals, int[] newInterval) {
        var newIntervals = new ArrayList<int[]>(intervals.length + 1);

        for (int[] interval : intervals) {
            if (newInterval != null && newInterval[0] < interval[0]) {
                newIntervals.add(newInterval);
                newInterval = null;
            }

            newIntervals.add(interval);
        }

        if (newInterval != null) {
            newIntervals.add(newInterval);
        }

        return newIntervals;
    }

    private boolean overlaps(int[] a, int[] b) {
        return a[0] <= b[0] && b[0] <= a[1];
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> inserted = insertSorted(intervals, newInterval);
        // System.out.println(inserted);
        var merged = new ArrayList<int[]>();

        merged.add(inserted.get(0));

        for (int[] interval : inserted) {
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
