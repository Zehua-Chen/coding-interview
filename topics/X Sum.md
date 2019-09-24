# X Sum

## Two Pointer

```c++
std::vector<int> nums;
std::sort(nums.begin(), nums.end());

const int search = x;
int i = 0;
int j = nums.count() - 1;

while (i < j)
{
    if (nums[i] + nums[j] == search)
    {
        ++i;
        // avoid duplicates
        while (i < j && nums[i] != nums[i - 1]) ++i;
    }
    else if (nums[i] + nums[j] < search)
    {
        i++;
    }
    else
    {
        ++j;
    }
}
```