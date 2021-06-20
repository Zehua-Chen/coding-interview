#pragma once

#include <iostream>
#include <iterator>
#include <random>
#include <string_view>
#include <unordered_map>

namespace solution {

template <typename RandomIt, typename RandomFunc>
void Shuffle(RandomIt begin, RandomIt end, RandomFunc &&random);

template <typename RandomIt>
bool Verify(RandomIt a_begin, RandomIt a_end, RandomIt b_begin, RandomIt b_end);

template <typename RandomIt, typename RandomFunc>
void Shuffle(RandomIt begin, RandomIt end, RandomFunc &&random) {
  using std::iterator_traits;
  using difference_type = typename iterator_traits<RandomIt>::difference_type;

  RandomIt i = begin;

  std::uniform_int_distribution<difference_type> dist{0, end - begin - 1};

  while (i < end) {
    RandomIt swap_i = begin + dist(random);
    std::iter_swap(i, swap_i);
    ++i;
  }
}

template <typename RandomIt>
bool Verify(RandomIt a_begin, RandomIt a_end, RandomIt b_begin,
            RandomIt b_end) {
  using std::iterator_traits;
  using value_type = typename iterator_traits<RandomIt>::value_type;

  std::unordered_map<value_type, size_t> occurance_a;
  std::unordered_map<value_type, size_t> occurance_b;

  while (a_begin < a_end) {
    ++occurance_a[*a_begin];
    ++a_begin;
  }

  while (b_begin < b_end) {
    ++occurance_b[*b_begin];
    ++b_begin;
  }

  if (occurance_a.size() != occurance_b.size()) {
    return false;
  }

  return std::all_of(occurance_a.begin(), occurance_a.end(), [&](auto pair) {
    return occurance_b[pair.first] == pair.second;
  });
}

}  // namespace solution