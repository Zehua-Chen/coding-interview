#include <iostream>
#include "solution.h"

using std::cout;
using std::endl;
using std::vector;
using std::string;

std::ostream &operator<<(std::ostream &out, const vector<string> &vec) {
  auto i = vec.begin();
  auto last = std::prev(vec.end());

  for (; i < last; ++i) {
    out << *i << ", ";
  }

  out << *last;

  return out;
}

int main() {
  vector<string> output = { "a", "b" };
  cout << output << endl;
  return 0;
}