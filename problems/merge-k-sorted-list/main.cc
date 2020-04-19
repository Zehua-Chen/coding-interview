#include <iostream>
#include "solution.h"

using std::cout;
using std::endl;

int main() {
  cout << std::boolalpha;

  auto first = ListNode::Create({1, 2, 3});
  auto second = ListNode::Create({1, 2, 3});

  cout << ListNode::Equals(first, second) << endl;
  return 0;
}
