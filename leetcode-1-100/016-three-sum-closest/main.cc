#include <iostream>
#include "solution.h"

using std::cout;
using std::endl;

int main() {
  Solution solution;
  // sorted: -4 -1 1 2
  std::vector<int> nums{ -1, 2, 1, -4 };

  cout << solution.ThreeSumClosest(nums, 1) << endl;
  return 0;
}