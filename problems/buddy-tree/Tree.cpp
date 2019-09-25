#include "Tree.hpp"

#include <iostream>

using std::initializer_list;
using std::vector;

using std::cout;
using std::endl;

Tree::Tree(const initializer_list<initializer_list<int>> &tree)
{
    _data.reserve(tree.size());

    for (const auto &layer: tree)
    {
        _data.emplace_back(layer.begin(), layer.end());
    }
}

void Tree::setBits(int offset, int length)
{
    _setBits(0, offset, length, 1);
}

void Tree::_setBits(int level, int offset, int length, int value)
{
    if (level == _data.size()) return;

    int nextLength = (length % 2 == 0) ? length / 2 : length / 2 + 1;

    if (level == 0)
    {
        vector<int> &current = _data[level];

        for (int i = offset; i < offset + length; ++i)
        {
            current[i] = value;
        }

        return _setBits(level + 1, offset / 2, nextLength, value);
    }

    vector<int> &current = _data[level];
    const vector<int> &children = _data[level - 1];

    for (int i = offset; i < offset + length; ++i)
    {
        int left = i * 2;
        int right = i * 2 + 1;

        current[i] = children[left] && children[right];
    }

    _setBits(level + 1, offset / 2, nextLength, value);
}

void Tree::clearBits(int offset, int length)
{
    _setBits(0, offset, length, 0);
}

std::ostream &operator<<(std::ostream &out, const Tree &tree)
{
    for (const vector<int> &layer: tree._data)
    {
        for (const auto &element: layer)
        {
            out << element << ", ";
        }

        out << std::endl;
    }

    return out;
}