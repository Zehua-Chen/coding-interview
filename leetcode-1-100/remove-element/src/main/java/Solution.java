public class Solution {
  public int removeElement(int[] nums, int val) {
    // Similar idea to remove-duplicates-from-sorted
    int newIndex = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == val) {
        continue;
      }

      nums[newIndex] = nums[i];
      newIndex++;
    }

    return newIndex;
  }
}
