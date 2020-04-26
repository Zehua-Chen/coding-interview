#include "solution.h"

using std::string;
using std::vector;

string Solution::LongestCommonPrefix(vector<string> &strs) {
  if (strs.size() == 0) return "";

  string prefix;

  // find min size
  size_t min_size = strs[0].size();

  for (const auto &str : strs) {
    if (str.size() < min_size) {
      min_size = str.size();
    }
  }

  for (size_t i = 0; i < min_size; ++i) {
    char c = strs[0][i];

    for (const auto &str : strs) {
      if (c != str[i]) {
        goto found;
      }
    }

    prefix += c;
  }

found:

  return prefix;
}
