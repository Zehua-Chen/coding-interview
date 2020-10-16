#include <iostream>
#include "solution.h"

using std::cout;
using std::endl;
using std::string;
using std::vector;

std::ostream &operator<<(std::ostream &out, const vector<string> &vec) {
  if (vec.empty()) {
    return out;
  }

  auto i = vec.begin();
  auto last = std::prev(vec.end());

  for (; i < last; ++i) {
    out << *i << ", ";
  }

  out << *last;

  return out;
}

int main() {
  Solution solution;
  cout << solution.LetterCombinations("22") << endl;
  return 0;
}