#include <iostream>
#include "solution.h"

using std::cout;
using std::endl;

void Test(const std::string &s, const std::string &p, const bool expected) {
  bool predicted = IsMatchRecursive(s, p);

  if (predicted != expected) {
    cout << "s = " << s << ", p = " << p << endl;
    cout << predicted << ", expected " << expected << endl;
    cout << endl;
  }
}

int main() {
  cout << std::boolalpha;

  // None star cases
  Test("aa", "a", false);
  Test("aa", "aaa", false);
  Test("aa", "aaaaaa", false);
  Test("aa", "aa", true);
  Test("aa", "a.", true);
  Test("aa", "..", true);
  Test("aa", "a*", true);
  Test("ab", ".*", true);
  Test("aab", "c*a*b", true);
  Test("mississippi", "mis*is*p*.", false);
  Test("aaa", "a*a", true);

  return 0;
}
