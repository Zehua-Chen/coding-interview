#include "solution.h"

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
  const ListNode *subroot = node;

  while (subroot) {
    out << subroot->val << "->";
    subroot = subroot->next;
  }

  out << "end";

  return out;
}

ListNode *Solution::mergeKLists(vector<ListNode *> &lists) { return nullptr; }
