package leetcode.p0057;

import java.util.*;

/** Runtime: O(N) Space: O(N) */
public class OptimalSolution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        var result = new ArrayList<int[]>();
        int i = 0;

        for (; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (interval[1] < newInterval[0]) {
                result.add(interval);
            } else if (newInterval[1] < interval[0]) {
                result.add(newInterval);
                result.add(interval);

                newInterval = null;
                break;
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        // we have reached the end of the array but still have not found an insertion point
        if (newInterval != null) {
            result.add(newInterval);
        }

        // insert the rest of the array, if not at the end
        for (i++; i < intervals.length; i++) {
            result.add(intervals[i]);
        }

        return result.toArray(new int[0][]);
    }
}
