#include "solution.h"
#include <algorithm>
#include <iostream>

using std::string;

struct Range {
  struct Iterator {
    size_t value;

    bool operator!=(const Iterator &other) const {
      return this->value != other.value;
    }

    size_t operator*() const { return this->value; }

    Iterator &operator++() {
      ++this->value;
      return *this;
    }
  };

  size_t begin_value;
  size_t end_value;

  Range(size_t begin, size_t end) : begin_value(begin), end_value(end) {}
  Iterator begin() const { return Iterator{begin_value}; }
  Iterator end() const { return Iterator{end_value}; }
};

static bool _IsMatchRecursive(const string &s, const string &p, size_t s_i,
                              size_t p_i, char prev) {

  if (s_i > s.length() && p_i > p.length()) {
    return true;
  }

  if (s_i > s.length() || p_i > p.length()) {
    return false;
  }

  char s_c = s[s_i];
  char p_c = p[p_i];

  if (p_c == '*') {
    Range range{s_i, s.length()};
    return std::any_of(range.begin(), range.end(), [=](size_t index) {
      std::cout << "index = " << index << std::endl;
      return _IsMatchRecursive(s, p, index, p_i, prev);
    });
  }

  if (p_c == '.') {
    return _IsMatchRecursive(s, p, s_i + 1, p_i + 1, p[p_i]);
  }

  if (s_c == p_c) {
    return _IsMatchRecursive(s, p, s_i + 1, p_i + 1, p[p_i]);
  }

  return false;
}

bool IsMatchRecursive(string s, string p) {
  return _IsMatchRecursive(s, p, 0, 0, 0);
}
