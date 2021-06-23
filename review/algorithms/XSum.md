# X Sum

## Preparation

```cpp
std::vector<int> nums;
std::sort(nums.begin(), nums.end());
```

## Nested Loops

```cpp
for (size_t i = start; i < nums.size(); i++) {
  if (i != start && nums[i] == num[i - 1]) {
    continue;
  }
  // more loops
}
```

- If the loop is the outer most loop, `start = 0`
- If the loop is a nested loop, `start = x + 1`, where `x` is the index of the
  parent loop

## Two Pointer Search

```cpp
size_t k = inner_most_loop_index + 1;
size_t l = nums.size() - 1;

while (k < l) {
  int sum = nums[i] + nums[j] + nums[k] + nums[l];

  if (sum == target) {
    solution.push_back(vector<int>{nums[i], nums[j], nums[k], nums[l]});
    ++k;

    while (k < l && nums[k] == nums[k - 1]) {
      ++k;
    }
  } else if (sum < target) {
    ++k;
  } else {
    --l;
  }
}
```
