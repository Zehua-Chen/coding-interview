#include "solution.h"
#include <algorithm>

ListNode *Solution::removeNthFromEnd(ListNode *head, int n) {
  // We solve this problem by using two pointers, first and second
  // and we maintain gap of size n between the two pointers
  // This way, when first is null, second would be the node we want to remove
  ListNode *first = head;
  ListNode *second = head;
  ListNode *second_prev = nullptr;

  // Give first n advance
  for (int i = 0; i < n; ++i) {
    first = first->next;
  }

  // Move two at the same time
  while (first) {
    first = first->next;

    second_prev = second;
    second = second->next;
  }

  // if whatever is before second is not null, then it means that we are
  // not dropping the head
  if (second_prev) {
    second_prev->next = second->next;
    return head;
  }

  return second->next;
}

ListNode *Create(const std::vector<int> &list) {
  ListNode **nodes = new ListNode*[list.size()];

  auto begin = list.begin();
  auto end = list.end();

  size_t i = 0;

  while (begin != end) {
    nodes[i++] = new ListNode(*begin);
    ++begin;
  }

  for (size_t i = 0; i < list.size() - 1; ++i) {
    nodes[i]->next = nodes[i + 1];
  }

  return nodes[0];
}

bool operator==(ListNode *head, const std::vector<int> &list) {
  return std::all_of(list.begin(), list.end(), [&](int expected) {
    int found = head->val;
    head = head->next;

    return found == expected;
  });
}
