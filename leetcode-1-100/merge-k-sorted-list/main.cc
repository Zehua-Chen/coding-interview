#include <iostream>
#include "solution.h"

using std::cout;
using std::endl;
using std::vector;

void Test(vector<ListNode *> lists, const ListNode *expected) {
  Solution solution;

  ListNode *output = solution.mergeKLists(lists);

  if (!ListNode::Equals(output, expected)) {
    cout << "failed" << endl;
    cout << "expected " << expected << endl;
    cout << "actual " << output << endl;
  }
}

int main() {
  Test({}, nullptr);

  Test({ListNode::Create({1, 2, 3})}, ListNode::Create({1, 2, 3}));

  Test({ListNode::Create({1, 4, 5}), ListNode::Create({1, 3, 4}),
        ListNode::Create({2, 6})},
       ListNode::Create({1, 1, 2, 3, 4, 4, 5, 6}));

  return 0;
}
