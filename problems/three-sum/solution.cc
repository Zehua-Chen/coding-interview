#include "solution.h"
#include <algorithm>
#include <iostream>
#include <set>
#include <unordered_map>

using std::cout;
using std::endl;
using std::set;
using std::string;
using std::unordered_map;
using std::vector;

vector<vector<int>> Solution::threeSum(vector<int> &nums) {
  std::sort(nums.begin(), nums.end());
  vector<vector<int>> solution;

  for (size_t i = 0; i < nums.size(); i++) {
    if (i != 0 && nums[i] == nums[i - 1]) continue;

    int j = i + 1;
    int k = nums.size() - 1;

    while (j < k) {
      if (nums[i] + nums[j] + nums[k] == 0) {
        solution.push_back({nums[i], nums[j], nums[k]});
        ++j;

        // never let j refer to the same thing twice
        while (j < k && nums[j] == nums[j - 1]) ++j;
      } else if (nums[i] + nums[j] + nums[k] < 0) {
        ++j;
      } else {
        --k;
      }
    }
  }

  return solution;
}