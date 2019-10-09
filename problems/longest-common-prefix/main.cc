#include <initializer_list>
#include <iostream>
#include "Solution.h"

using std::cout;
using std::endl;
using std::initializer_list;
using std::string;
using std::vector;

void TestStrings(initializer_list<string> strs) {
  cout << "===============================" << endl;
  cout << "input: ";

  for (const auto &str : strs) {
    cout << str << ", ";
  }

  cout << endl;

  Solution solution;
  vector<string> input{strs};

  string output = solution.LongestCommonPrefix(input);

  cout << "output: " << output << "(" << output.size() << ")" << endl;
}

int main() {
  TestStrings({"flower", "flow", "flight"});
  TestStrings({"dog", "racecar", "car"});
}