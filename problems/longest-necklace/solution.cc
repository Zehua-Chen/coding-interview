#include "solution.h"
#include <algorithm>
#include <iostream>
#include <string>
#include <unordered_set>

using std::basic_string;
using std::max_element;
using std::unordered_set;
using std::vector;

using std::cout;
using std::endl;

size_t LongestNecklace(const vector<size_t> &beads) {
  if (beads.size() == 0) {
    return 0;
  }

  unordered_set<size_t> unresolved{beads.begin(), beads.end()};
  unordered_set<size_t> active;

  size_t max_size = 0;
  size_t current = *unresolved.begin();

  while (!unresolved.empty()) {
    unresolved.erase(current);
    active.insert(current);

    size_t next = beads[current];
    current = next;

    // find cycle
    if (active.find(next) != active.end()) {
      for (const auto &active_bead : active) {
        unresolved.erase(active_bead);
      }

      if (active.size() > max_size) {
        max_size = active.size();
      }

      active.clear();

      if (unresolved.size() > 0) {
        current = *unresolved.begin();
      }
    }
  }

  return max_size;
}