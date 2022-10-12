public class Solution {
    public int solution(int n) {
        if (n == 1) {
            return 1;
        }

        int outerLayer = n * 2 + 2 * (n - 2);

        return solution(n - 1) + outerLayer;
    }
}
