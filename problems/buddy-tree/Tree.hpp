#pragma once

#include <initializer_list>
#include <ostream>
#include <vector>

class Tree;

std::ostream &operator<<(std::ostream &out, const Tree &tree);

class Tree
{
public:
    Tree(const std::initializer_list<std::initializer_list<int>> &tree);
    void setBits(int offset, int length);
    void clearBits(int offset, int length);

    friend std::ostream &operator<<(std::ostream &out, const Tree &tree);

private:
    std::vector<std::vector<int>> _data;

    void _setBits(int level, int offset, int length, int value);
};

