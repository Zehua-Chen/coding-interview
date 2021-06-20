#include <iostream>
#include <random>
#include <string>
#include "solution.h"

using std::cout;
using std::endl;

int main() {
  std::mt19937 mt;

  std::string original{"abcedf"};
  std::string shuffled{original};

  solution::Shuffle(shuffled.begin(), shuffled.end(), mt);

  cout << std::boolalpha;

  cout << "original: " << original << endl;
  cout << "shuffled: " << shuffled << endl;

  cout << "match ? "
       << solution::Verify(original.begin(), original.end(), shuffled.begin(),
                           shuffled.end())
       << endl;

  return 0;
}