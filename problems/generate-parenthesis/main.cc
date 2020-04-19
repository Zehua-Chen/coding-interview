#include <iostream>
#include <unordered_set>
#include "solution.h"

using std::cout;
using std::endl;
using std::string;
using std::unordered_set;
using std::vector;

void Test(int n, vector<string> expected) {
  Solution solution;

  vector<string> result = solution.generateParenthesis(n);

  if (result.size() != expected.size()) {
    cout << "expected " << expected.size() << " elements, found "
         << result.size() << endl;
    return;
  }

  std::sort(result.begin(), result.end());
  std::sort(expected.begin(), expected.end());

  for (size_t i = 0; i < expected.size(); ++i) {
    if (expected[i] != result[i]) {
      cout << "expect " << expected[i] << ", found " << result[i] << endl;
      return;
    }
  }
}

int main() {
  Test(3, {"((()))", "(()())", "(())()", "()(())", "()()()"});
  return 0;
}
