#include "Solution.hpp"
#include <initializer_list>
#include <iostream>

using std::cout;
using std::endl;
using std::initializer_list;
using std::string;
using std::vector;

void TestStrings(initializer_list<int> numbers)
{
    cout << "===============================" << endl;
    cout << "input: ";

    for (const auto &number : numbers)
    {
        cout << number << ", ";
    }

    cout << endl;

    Solution solution;
    vector<int> input{ numbers };

    vector<vector<int>> output = solution.threeSum(input);

    cout << "output: " << endl;

    for (const auto &pair : output)
    {
        if (pair.size() != 3)
        {
            cout << "each pair can only has 3 elements, found " << pair.size()
                 << endl;
            exit(1);
        }

        cout << pair[0] << ", " << pair[1] << ", " << pair[2] << endl;
    }

    cout << endl;
}

int main()
{
    TestStrings({ -1, 0, 1, 2, -1, -4 });
    TestStrings({ -1, -1, 2 });
}