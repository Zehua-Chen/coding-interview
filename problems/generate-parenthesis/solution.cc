#include "solution.h"

using std::string;
using std::vector;

vector<string> Solution::generateParenthesis(int n) {
  if (n == 0) {
    return vector<string>();
  }

  vector<string> result;

  struct State {
    string progress;
    size_t depth;
  };

  vector<State> stack;

  stack.push_back(State{"(", 1});

  while (!stack.empty()) {
    State pop = stack[stack.size() - 1];
    stack.pop_back();

    if (pop.progress.size() == n * 2) {
      if (pop.depth == 0) {
        result.push_back(pop.progress);
      }

      continue;
    }

    if (pop.depth == 0) {
      string new_progress = pop.progress + '(';
      size_t new_depth = 1;

      stack.push_back(State{new_progress, new_depth});
      continue;
    }

    string left = pop.progress + '(';
    string right = pop.progress + ')';

    stack.push_back(State{left, pop.depth + 1});
    stack.push_back(State{right, pop.depth - 1});
  }

  return result;
}
