#pragma once

#include <iostream>
#include <ostream>

// Declaration

template <typename T>
void DumpContent(const T &value, std::ostream &out = std::cout);

// Implementation

template <typename T>
void DumpContent(const T &value, std::ostream &out) {
  return;
}