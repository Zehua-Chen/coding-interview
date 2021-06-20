#pragma once

#include <iostream>
#include <ostream>
#include <string>
#include <algorithm>

// Declaration

template <typename T>
void DumpContent(const T &value, std::ostream &out = std::cout);
void DumpByte(unsigned char byte, std::ostream &out = std::cout);

// Implementation

template <typename T>
void DumpContent(const T &value, std::ostream &out) {
  const char *bytes = reinterpret_cast<const char *>(&value);

  for (size_t i = 0; i < sizeof(value); ++i) {
    out << i << ": ";
    DumpByte(bytes[i], out);
    out << std::endl;
  }
}

void DumpByte(unsigned char byte, std::ostream &out) {
  char byte_dump[9];

  for (size_t i = 0; i < 8; ++i) {
    unsigned char bit = byte & 0x1;
    byte >>= 1;

    if (bit) {
      byte_dump[i] = '1';
    } else {
      byte_dump[i] = '0';
    }
  }

  byte_dump[8] = 0;
  std::reverse(std::begin(byte_dump), std::end(byte_dump) - 1);

  out << byte_dump;
}