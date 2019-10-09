#include <initializer_list>
#include <iostream>
#include "Tree.h"

using std::cout;
using std::endl;
using std::initializer_list;

void TestSetBits(initializer_list<initializer_list<int>> input) {
  cout << "====================Test Set=====================" << endl;

  Tree tree{input};

  cout << "before" << endl;
  cout << tree;

  tree.SetBits(1, 3);

  cout << "after" << endl;
  cout << tree;
}

void TestClearBits(initializer_list<initializer_list<int>> input) {
  cout << "====================Test Clear=====================" << endl;

  Tree tree{input};

  cout << "before" << endl;
  cout << tree;

  tree.ClearBits(1, 3);

  cout << "after" << endl;
  cout << tree;
}

int main() {
  TestSetBits({
      {1, 0, 0, 0, 1, 1, 0, 0},
      {1, 0, 1, 0},
      {0, 0},
      {0},
  });

  TestClearBits({
      {1, 1, 1, 0, 1, 1, 0, 0},
      {0, 0, 1, 0},
      {0, 0},
      {0},
  });

  return 0;
}