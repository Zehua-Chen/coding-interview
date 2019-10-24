#include <algorithm>
#include <iterator>
#include <cmath>
#include <iostream>
#include "solution.h"

using std::vector;

static int Difference(int a, int b) {
  return std::abs(a - b);
}

int Solution::ThreeSumClosest(vector<int> &nums, int target) {
  std::sort(nums.begin(), nums.end());

  // sample array
  // -1 -1 2 4

  auto end = nums.end();
  auto i = nums.begin();

  int best_value = *i + *std::next(i) + *std::prev(end);
  int best_difference = Difference(best_value, target);

  for (; i < end; ++i) {
    auto j = std::next(i);
    auto k = std::prev(end);

    while (j < k) {
      int temp_value = *i + *j + *k;
      int temp_distance = temp_value - target;
      int temp_difference = Difference(temp_value, target);

      if (temp_difference < best_difference) {
        best_value = temp_value;
        best_difference = temp_difference;
      }

      if (temp_distance < 0) {
        j = std::next(j);
      } else if (temp_distance > 0) {
        k = std::prev(k);
      } else if (temp_distance == 0) {
        return target;
      }
    }
  }

  return best_value;
}