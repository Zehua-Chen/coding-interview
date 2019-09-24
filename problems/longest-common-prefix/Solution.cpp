#include "Solution.hpp"

using std::string;
using std::vector;

string Solution::longestCommonPrefix(vector<string> &strs)
{
    if (strs.size() == 0) return "";

    string prefix;

    // find min size
    size_t minSize = strs[0].size();

    for (const auto &str: strs)
    {
        if (str.size() < minSize)
        {
            minSize = str.size();
        }
    }

    for (size_t i = 0; i < minSize; ++i)
    {
        char c = strs[0][i];

        for (const auto &str: strs)
        {
            if (c != str[i])
            {
                goto found;
            }
        }

        prefix += c;
    }

    found:

    return prefix;
}