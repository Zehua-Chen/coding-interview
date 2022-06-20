class Solution {
    public int mySqrt(int x) {
        // have to use long here, otherwise for very big number like 2 ^ 31 - 1
        // end * end will overflow
        long start = 0;
        long end = x;

        while (start < end) {
            long interval = end - start + 1;

            if (interval % 2 != 0) {
                long mid = (interval / 2) + start;

                if (mid * mid == x) {
                    return (int)mid;
                } else if (mid * mid < x) {
                    start = mid;
                } else if (mid * mid > x) {
                    end = mid;
                }
            } else {
                long mid1 = (interval / 2) + start;
                long mid0 = mid1 - 1;

                if (mid1 * mid1 == x) {
                    return (int)mid1;
                } else if (mid0 * mid0 == x) {
                    return (int)mid0;
                } else if (mid1 * mid1 > x && mid0 * mid0 < x) {
                    return (int)mid0;
                } else if (mid1 * mid1 > x && mid0 * mid0 > x) {
                    end = mid1;
                } else if (mid1 * mid1 < x && mid0 * mid0 < x) {
                    start = mid0;
                }
            }
        }

        return (int)start;
    }
}
