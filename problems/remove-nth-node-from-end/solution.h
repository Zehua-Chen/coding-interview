#pragma once

#include <vector>

struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(nullptr) {}
};

class Solution {
 public:
  ListNode* removeNthFromEnd(ListNode* head, int n);
};

ListNode *Create(const std::vector<int> &list);
bool operator==(ListNode *head, const std::vector<int> &list);
