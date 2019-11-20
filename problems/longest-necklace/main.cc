#include <iostream>
#include "solution.h"

using std::cout;
using std::endl;

int main() {
  cout << LongestNecklace({}) << endl;
  cout << LongestNecklace({1, 0}) << endl;
  cout << LongestNecklace({1, 2, 0}) << endl;
  cout << LongestNecklace({5, 4, 0, 3, 1, 6, 2}) << endl;

  return 0;
}