/*
custom test cases

[2,2,1,1,1,1,1,1,1,1]
*/

// https://medium.com/tech-life-fun/leet-code-84-largest-rectangle-in-histogram-graphically-explained-python3-solution-df7e0d37ae4d
class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];

            for (int top = 0; top <= height; top++) {
                int count = 0;

                for (int ip = i; ip < heights.length; ip++) {
                    if (heights[ip] < top) {
                        break;
                    }

                    count++;
                }

                max = Math.max(max, count * top);
            }
        }

        return max;
    }
}
