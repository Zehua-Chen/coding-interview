#include <iostream>
#include "solution.h"

using std::cout;
using std::endl;

int main() {
  DumpContent(static_cast<char>(0xFA));
  cout << endl;

  DumpContent(0x1);
  cout << endl;

  DumpContent(0xFA);

  return 0;
}