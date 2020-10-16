#include "solution.h"
#include <algorithm>
#include <iostream>

using std::vector;

vector<vector<int>> FourSum(vector<int>& nums, int target) {
  std::sort(nums.begin(), nums.end());
  vector<vector<int>> solution;

  for (size_t i = 0; i < nums.size(); ++i) {
    if (i != 0 && nums[i] == nums[i - 1]) {
      continue;
    }

    for (size_t j = i + 1; j < nums.size(); ++j) {
      if (j != i + 1 && nums[j] == nums[j - 1]) {
        continue;
      }

      size_t k = j + 1;
      size_t l = nums.size() - 1;

      while (k < l) {
        int sum = nums[i] + nums[j] + nums[k] + nums[l];

        if (sum == target) {
          // std::cout << "i = " << i << ", ";
          // std::cout << "j = " << j << ", ";
          // std::cout << "k = " << k << ", ";
          // std::cout << "l = " << l << std::endl;

          solution.push_back(vector<int>{nums[i], nums[j], nums[k], nums[l]});
          ++k;

          while (k < l && nums[k] == nums[k - 1]) {
            ++k;
          }
        } else if (sum < target) {
          ++k;
        } else {
          --l;
        }
      }
    }
  }

  return solution;
}