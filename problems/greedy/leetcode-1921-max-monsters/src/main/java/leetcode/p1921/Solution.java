package leetcode.p1921;

import java.util.*;

public class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        var arrivalTimes = new float[dist.length];

        for (int i = 0; i < dist.length; i++) {
            arrivalTimes[i] = dist[i] / (float) speed[i];
        }

        Arrays.sort(arrivalTimes);

        float time = 0;
        int count = 0;

        for (float arrivalTime : arrivalTimes) {
            if (time >= arrivalTime) {
                break;
            }

            count++;
            time += 1.0f;
        }

        return count;
    }
}
