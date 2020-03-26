#include "solution.h"
#include <stack>

/**
 * Determine if peek is the reverse of current
 */
static bool IsReverse(char peek, char current) {
  switch (current) {
    case ')':
      return peek == '(';
    case ']':
      return peek == '[';
    case '}':
      return peek == '{';
  }

  return false;
}

bool Solution::isValid(std::string s) {
  std::stack<char> stack;

  for (const char c : s) {
    switch (c) {
      case '(':
      case '{':
      case '[':
        stack.push(c);
        break;
      case ')':
      case '}':
      case ']':
        if (stack.empty()) {
          return false;
        }

        if (!IsReverse(stack.top(), c)) {
          return false;
        }

        stack.pop();
        break;
    }
  }

  return stack.empty();
}
