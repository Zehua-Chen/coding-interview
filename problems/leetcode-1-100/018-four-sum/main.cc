#include "solution.h"
#include <iostream>
#include <iterator>
#include <initializer_list>

using std::cout;
using std::endl;
using std::vector;
using std::initializer_list;

std::ostream &operator<<(std::ostream &out, vector<int> nums) {
  out << "[";

  if (nums.size() != 0) {
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
    out << "  " << row << endl;
  }

  out << "]";
  return out;
}

void Test(initializer_list<int> init_nums) {
  vector<int> nums{init_nums};
  vector<vector<int>> solution = FourSum(nums, 0);

  cout << solution << endl << endl;
}

int main() {
  Test({1, 0, -1, 0, -2, 2});
  Test({0, 0, 0, 0});
  Test({-3, -2, -1, 0, 0, 1, 2, 3});

  return 0;
}