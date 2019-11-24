#include "solution.h"
#include <iostream>

using std::cout;
using std::endl;

void Test(const std::string &s, const std::string &p, const bool expected) {
  cout << "s = " << s << ", p = " << p << endl;
  cout << IsMatch(s, p) << ", expected " << expected << endl;
  cout << endl;
}

int main() {
  cout << std::boolalpha;

  // Test("aa", "a", false);
  // Test("aa", "aaa", false);
  // Test("aa", "aaaaaa", false);
  // Test("aa", "a*", true);
  Test("ab", ".*", true);
  // Test("aab", "c*a*b", true);
  // Test("mississippi", "mis*is*p*.", false);
  // Test("aaa", "a*a", true);

  return 0;
}