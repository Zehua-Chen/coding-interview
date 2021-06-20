package p009;

import java.util.HashMap;

public class Solution {
    public boolean comp(int[] as, int[] bs) {
        // An element might appear twice; so a set does not work
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

        // NOTE:
        // Two arrays must have the "same" elements, which means it goes both ways
        for (int count : mapA.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
