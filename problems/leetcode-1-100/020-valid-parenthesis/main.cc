#include "solution.h"

using std::cout;
using std::endl;

void Test(std::string s, bool expected) {
  Solution solution;

  if (solution.isValid(std::move(s)) != expected) {
    cout << "expect " << expected << ", found " << !expected << endl;
  }
}

int main() {
  cout << std::boolalpha;

  Test("", true);
  Test("()", true);
  Test("([])", true);
  Test("([{}])", true);
  Test("()[]{}", true);
  Test("{[]}", true);

  Test("(]", false);
  Test("([)]", false);

  return 0;
}
