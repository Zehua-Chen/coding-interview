package p009;

import java.util.HashMap;

public class Solution {
    public boolean comp(int[] as, int[] bs) {
        var mapA = new HashMap<Integer, Integer>();

        for (int a : as) {
            int squared = a * a;
            mapA.putIfAbsent(squared, 0);
            mapA.put(squared, mapA.get(squared) + 1);
        }

        for (int b : bs) {
            if (!mapA.containsKey(b)) {
                return false;
            }

            int count = mapA.get(b);
            count--;

            if (count < 0) {
                return false;
            }

            mapA.put(b, count);
        }

        for (int count : mapA.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
