#pragma once

#include <initializer_list>
#include <ostream>
#include <vector>

struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(nullptr) {}

  void *address() { return reinterpret_cast<void *>(this); }

  static bool Equals(const ListNode *a, const ListNode *b);
  static ListNode *Create(std::initializer_list<int> values);
};

std::ostream &operator<<(std::ostream &out, const ListNode *node);

class Solution {
 public:
  ListNode *mergeKLists(std::vector<ListNode *> &lists);
};
