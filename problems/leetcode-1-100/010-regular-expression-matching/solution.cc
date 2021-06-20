#include "solution.h"
#include <algorithm>
#include <iostream>

using std::string;

bool IsMatchRecursive(string s, string p) {
  // if pattern is empty, string should also be empty
  if (p.empty()) {
    return s.empty();
  }

  // if the string is emtpy, then the first letter does not match
  // Otherwise: if the first letters either match or the first of pattern is .,
  // then we say the first match
  bool first_match = !s.empty() && ((s[0] == p[0]) || p[0] == '.');

  // If the second letter in the pattern is a '*'
  if (p.length() >= 2 && p[1] == '*') {
    // *'s definition: whatever appears before can appear zero or more times
    // IsMatchRecursive(s, p.substr(2)): handles the "zero" case
    // IsMatchRecursive(s.substr(1), p): handles the "more" case
    return IsMatchRecursive(s, p.substr(2)) ||
           (first_match && IsMatchRecursive(s.substr(1), p));
  }

  // if no '*' is present, move on
  return first_match && IsMatchRecursive(s.substr(1), p.substr(1));
}
