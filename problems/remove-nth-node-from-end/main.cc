#include "solution.h"
#include <iostream>

using std::cout;
using std::endl;

void Test(ListNode *head, int n, std::vector<int> list) {
  Solution solution;

  head = solution.removeNthFromEnd(head, n);

  if (head == list) {
    return;
  }

  cout << "failed for n = " << n << endl;
}

int main() {
  Test(Create({ 1, 2, 3, 4, 5 }), 1, { 1, 2, 3, 4 });
  Test(Create({ 1, 2, 3, 4, 5 }), 2, { 1, 2, 3, 5 });
  Test(Create({ 1, 2, 3, 4, 5 }), 5, { 2, 3, 4, 5 });
  return 0;
}
