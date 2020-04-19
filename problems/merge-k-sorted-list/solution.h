#pragma once

#include <vector>
#include <initializer_list>
#include <ostream>

struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(nullptr) {}

  static bool Equals(const ListNode *a, const ListNode *b);
  static ListNode *Create(std::initializer_list<int> values);
};

std::ostream &operator<<(std::ostream &out, const ListNode *node);

class Solution {
 public:
  ListNode* mergeKLists(std::vector<ListNode*>& lists);
};
