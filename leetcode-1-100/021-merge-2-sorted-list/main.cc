#include <initializer_list>
#include <iostream>
#include <vector>
#include "solution.h"

using std::cout;
using std::endl;
using std::initializer_list;
using std::vector;

ListNode *CreateNodes(const initializer_list<int> &list,
                      vector<ListNode *> &nodes) {
  ListNode *prev = nullptr;
  ListNode *head = nullptr;

  for (int value : list) {
    auto node = new ListNode(value);
    nodes.push_back(node);

    if (prev) {
      prev->next = node;
      prev = node;
    } else {
      prev = node;
    }

    if (!head) {
      head = node;
    }
  }

  return head;
}

void Test(initializer_list<int> l1, initializer_list<int> l2,
          initializer_list<int> expected) {
  vector<ListNode *> nodes;

  ListNode *l1_nodes = CreateNodes(l1, nodes);
  ListNode *l2_nodes = CreateNodes(l2, nodes);

  Solution solution;

  ListNode *output = solution.mergeTwoLists(l1_nodes, l2_nodes);

  for (int expected : expected) {
    if (!output) {
      cout << "output ended permaturely" << endl;
      break;
    }

    if (output->val == expected) {
      output = output->next;
    } else {
      cout << "expected " << expected << ", found " << output->val << endl;
      break;
    }
  }

  for (ListNode *node : nodes) {
    delete node;
  }
}

int main() {
  Test({1, 2, 4}, {1, 3, 4}, {1, 1, 2, 3, 4, 4});
  Test({1, 2, 3}, {4, 5, 6}, {1, 2, 3, 4, 5, 6});

  Test({1}, {4, 5, 6}, {1, 4, 5, 6});
  Test({}, {}, {});
  return 0;
}
