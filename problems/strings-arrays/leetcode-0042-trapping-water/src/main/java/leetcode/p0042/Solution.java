package leetcode.p0042;

public class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int volume = 0;

        int leftMax = 0;
        int rightMax = 0;

        // The essence of the problem is to find g(i) = min(max(H[1..i]), max(H[i..n]))
        // max(H[1..i]) and max(H[i..n]) are all non-decreasing lines.
        //
        // This can be solved using the lower envelope technique
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    volume += leftMax - height[left];
                }

                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    volume += rightMax - height[right];
                }

                right--;
            }
        }

        return volume;
    }
}
