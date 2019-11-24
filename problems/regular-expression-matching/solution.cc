#include "solution.h"

using std::string;

enum class PatternType {
  // a
  kFixed,
  // .
  kAny,
  // a*
  kMany
};

static PatternType GetPatternType(
    const string::const_iterator &i,
    const string::const_iterator &end) {

  if (*i == '.') {
    return PatternType::kAny;
  }

  const auto next = std::next(i);

  if (next != end) {
    if (*next == '*') {
      return PatternType::kMany;
    }
  }

  return PatternType::kFixed;
}

static void PatternIterAdvance(
    string::const_iterator &i,
    const string::const_iterator &end,
    const PatternType &type) {

  switch (type) {
    case PatternType::kAny:
    case PatternType::kFixed:
      ++i;
      break;
    case PatternType::kMany:
      std::advance(i, 2);
      break;
  }
}

bool IsMatch(const std::string &s, const std::string &p) {
  auto p_begin = p.begin();
  auto p_end = p.end();

  auto s_begin = s.begin();
  auto s_end = s.end();

  PatternType type;

  while (p_begin != p_end) {
    if (s_begin == s_end) {

      if (type == PatternType::kMany) {
        auto s_last = std::prev(s_end);

        if (*s_last != *p_begin) {
          return false;
        }

        ++p_begin;

        return p_begin == p_end;
      }

      return false;
    }

    type = GetPatternType(p_begin, p_end);

    switch (type) {
      case PatternType::kFixed:
        if (*s_begin != *p_begin) {
          return false;
        }

        ++s_begin;
        break;
      case PatternType::kAny:
        ++s_begin;
        break;
      case PatternType::kMany: {
        const char expect_letter = *p_begin;

        while (*s_begin == expect_letter) {
          ++s_begin;
        }

        break;
      }
    }

    PatternIterAdvance(p_begin, p_end, type);
  }

  return s_begin == s_end;
}