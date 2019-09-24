#include "Solution.hpp"
#include <iostream>
#include <set>
#include <unordered_map>

using std::cout;
using std::endl;
using std::set;
using std::string;
using std::unordered_map;
using std::vector;

vector<vector<int>> Solution::threeSum(vector<int> &nums)
{
    // number: occurances
    unordered_map<int, int> record;

    for (const auto &num: nums)
    {
        auto found = record.find(num);

        if (found == record.end())
        {
            record[num] = 1;
            continue;
        }

        record[num]++;
    }

    size_t i = 0;
    vector<vector<int>> solutions;

    while (record.size() >= 3)
    {
        vector<int> solution;
        auto begin = record.begin();

        solution.push_back(begin->first);
        --begin->second;

        if (begin->second == 0)
        {
            record.erase(begin);
        }

        for (auto &pair: record)
        {
            int second = pair.first;
            int secondCount = pair.second - 1;

            int expectedThird = 0 - solution[0] - second;

            if (expectedThird == second && secondCount == 0)
            {
                continue;
            }

            if (record.find(expectedThird) == record.end())
            {
                break;
            }

            solution.push_back(second);
            solution.push_back(expectedThird);

            break;
        }

        // remove from dict
        record.erase(solution[1]);
        record.erase(solution[2]);

        if (solution.size() != 3)
        {
            continue;
        }

        solutions.push_back(std::move(solution));
    }

    return solutions;
}