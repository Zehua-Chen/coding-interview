#include "solution.h"
#include <iostream>

using std::cout;
using std::endl;

using std::initializer_list;
using std::ostream;
using std::vector;

bool ListNode::Equals(const ListNode *a, const ListNode *b) {
  if (a == b) {
    return true;
  }

  if (a->val != b->val) {
    return false;
  }

  if (a->next == nullptr && b->next == nullptr) {
    return true;
  }

  if (a->next == nullptr && b->next != nullptr) {
    return false;
  }

  if (a->next != nullptr && b->next == nullptr) {
    return false;
  }

  return ListNode::Equals(a->next, b->next);
}

ListNode *ListNode::Create(initializer_list<int> values) {
  auto begin = values.begin();
  auto end = values.end();

  if (begin == end) {
    return nullptr;
  }

  ListNode *root = new ListNode{*begin};
  ListNode *prev = root;
  ++begin;

  while (begin != end) {
    ListNode *next = new ListNode{*begin};
    prev->next = next;
    prev = next;

    ++begin;
  }

  return root;
}

ostream &operator<<(ostream &out, const ListNode *node) {
  if (!node) {
    out << "null";
    return out;
  }

  const ListNode *subroot = node;

  while (subroot) {
    out << subroot->val << "->";
    subroot = subroot->next;
  }

  out << "end";

  return out;
}

static ListNode *FindSmallest(vector<ListNode *> &lists) {
  size_t smallest_i = lists.size();

  for (size_t i = 0; i < lists.size(); ++i) {
    if (lists[i]) {
      smallest_i = i;
      break;
    }
  }

  for (size_t i = 0; i < lists.size(); ++i) {
    ListNode *list = lists[i];

    if (!list) {
      continue;
    }

    if (list->val < lists[smallest_i]->val) {
      smallest_i = i;
    }
  }

  if (smallest_i >= lists.size()) {
    return nullptr;
  }

  ListNode *output = lists[smallest_i];

  if (!output) {
    return nullptr;
  }

  lists[smallest_i] = output->next;
  output->next = nullptr;

  return output;
}

ListNode *Solution::mergeKLists(vector<ListNode *> &lists) {
  if (lists.empty()) {
    return nullptr;
  }

  ListNode *root = FindSmallest(lists);
  ListNode *prev = root;

  ListNode *smallest;

  while ((smallest = FindSmallest(lists))) {
    prev->next = smallest;
    prev = smallest;
  }

  return root;
}
