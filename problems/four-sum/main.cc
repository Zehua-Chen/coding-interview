#include <iostream>
#include <iterator>
#include "solution.h"

using std::cout;
using std::endl;
using std::vector;

std::ostream &operator<<(std::ostream &out, vector<int> nums) {
  out << "[";

  if (nums.size() == 0) {
    auto begin = nums.begin();
    auto last = std::prev(nums.end());

    while (begin != last) {
      out << *begin << " ";
      ++begin;
    }

    out << *begin;
  }

  out << "]";

  return out;
}

std::ostream &operator<<(std::ostream &out, vector<vector<int>> solution) {
  out << "[" << endl;

  for (const auto &row : solution) {
    out << row << endl;
  }

  out << "]";
  return out;
}

int main() {
  vector<int> nums{1, 0, -1, 0};
  vector<vector<int>> solution = FourSum(nums, 0);

  cout << solution << endl;

  return 0;
}