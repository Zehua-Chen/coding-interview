public class Solution {
    public int solution(int[] statues) {
        Arrays.sort(statues);

        int total = 0;

        for (int i = 1; i < statues.length; i++) {
            int current = statues[i];
            int previous = statues[i - 1];

            total += current - previous - 1;
        }

        return total;
    }

}
