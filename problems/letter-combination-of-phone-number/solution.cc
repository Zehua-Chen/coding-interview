#include "solution.h"
#include <algorithm>
#include <cmath>
#include <iostream>
#include <iterator>

using std::string;
using std::vector;

size_t Solution::LetterToInt(const char &letter) {
  return static_cast<size_t>(letter) - 48;
}

vector<string> Solution::LetterCombinations(string digits) {
  if (digits.empty()) {
    return {};
  }

  static const char *digit_to_strs[] = {
      nullptr,  // zero does not exist
      nullptr,  // 1 does not have letters
      "abc",    // 2
      "def",    // 3
      "ghi",    // 4
      "jkl",    // 5
      "mno",    // 6
      "pqrs",   // 7
      "tuv",    // 8
      "wxyz",   // 9
  };

  static const size_t digit_to_strs_size[] = {
      0,  // zero does not exist
      0,  // 1 does not have letters
      3,  // 2
      3,  // 3
      3,  // 4
      3,  // 5
      3,  // 6
      4,  // 7
      3,  // 8
      4,  // 9
  };

  // the i(s) of digits
  vector<size_t> digit_is;
  digit_is.resize(digits.size());

  size_t result_size = 1;

  for (const auto &letter : digits) {
    size_t digit = LetterToInt(letter);
    result_size *= digit_to_strs_size[digit];
  }

  vector<string> result;
  result.reserve(result_size);

  size_t result_i = 0;

  for (; result_i < result_size; ++result_i) {
    string temp;
    temp.reserve(digits.size());

    auto first_digit = LetterToInt(digits[0]);

    for (size_t digit_i = 0; digit_i < digits.size(); ++digit_i) {
      size_t digit = LetterToInt(digits[digit_i]);

      if (digit_is[digit_i] >= digit_to_strs_size[digit]) {
        digit_is[digit_i] = 0;
        auto next_digit_i = digit_i + 1;

        if (next_digit_i < digits.size()) {
          ++digit_is[next_digit_i];
          break;
        }
      }

      temp.push_back(digit_to_strs[digit][digit_is[digit_i]]);
    }

    ++digit_is[0];

    result.push_back(std::move(temp));
  }

  return result;
}